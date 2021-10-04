package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText p1;
    private EditText p2;
    private EditText p3;
    private TextView resultado;
    private Boolean media;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        p3 = findViewById(R.id.p3);
        calcular = findViewById(R.id.calcular);
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
        } else {
            resultado.setText("Reprovado! Sua média foi " + media);
        }
    }

    public void limpar (View view) {
        p1.setText("");
        p2.setText("");
        p3.setText("");
        resultado.setText("");
    }
}