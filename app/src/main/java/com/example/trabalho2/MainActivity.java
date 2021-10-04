package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText p1, p2, p3;
    private TextView resultado, status;
    private Boolean media;
    private Button calcular, proximaTela;
    public static final String EXTRA_TEXT1 = "com.example.application.example.EXTRA_TEXT1";
    public static final String EXTRA_TEXT2 = "com.example.application.example.EXTRA_TEXT2";
    public static final String EXTRA_TEXT3 = "com.example.application.example.EXTRA_TEXT3";
    public static final String EXTRA_TEXT4 = "com.example.application.example.EXTRA_TEXT4";
    public static final String EXTRA_TEXT5 = "com.example.application.example.EXTRA_TEXT5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado_final);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        calcular = findViewById(R.id.calcular);
        status = findViewById(R.id.status);

        proximaTela = findViewById(R.id.proxTela);
        proximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOutraTela();
            }
        });
    }

    public void calcular (View view) {
        double nota1 = Double.parseDouble(p1.getText().toString());
        double nota2 = Double.parseDouble(p2.getText().toString());
        double nota3 = Double.parseDouble(p3.getText().toString());
        double media = ((nota1 * 2 + nota2 * 3) / 5);

        if (nota3 < 0) {
            media = (nota1 + nota2);
        } else if (nota1 < nota2) {
            media = (nota2 + nota3);
        } else if (nota2 < nota1) {
            media = (nota1 + nota3);
        }

        if (media >= 6) {
            resultado.setText("Aprovado! Sua média foi " + media);
            status.setText("Aprovado");
        } else {
            resultado.setText("Reprovado! Sua média foi " + media);
            status.setText("Reprovado");
        }
    }

    public void openOutraTela() {
        double nota1 = Double.parseDouble(p1.getText().toString());
        double nota2 = Double.parseDouble(p2.getText().toString());
        double nota3 = Double.parseDouble(p3.getText().toString());
        double mediaString = Double.parseDouble(media.toString());
        String status_final = status.getText().toString();

        Intent intent = new Intent(this, outra_tela.class);
        intent.putExtra(EXTRA_TEXT1, nota1);
        intent.putExtra(EXTRA_TEXT2, nota2);
        intent.putExtra(EXTRA_TEXT3, nota3);
        intent.putExtra(EXTRA_TEXT4, mediaString);
        intent.putExtra(EXTRA_TEXT5, status_final);
        startActivity(intent);
    }

    public void limpar (View view) {
        p1.setText("");
        p2.setText("");
        p3.setText("");
        resultado.setText("");
        status.setText("");
    }
}