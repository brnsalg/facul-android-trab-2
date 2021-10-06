package com.example.trabalho2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class outra_tela extends AppCompatActivity {

    private Button anteriorTela;
    private TextView resultado_final, status, faltas, nome;
    private EditText p1, p2, p3, disciplina, media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra_tela);

        Intent intent = getIntent();
        String nota_11 = intent.getStringExtra(MainActivity.EXTRA_TEXT);
        String nota_22 = intent.getStringExtra(MainActivity.EXTRA_TEXT2);
        String nota_33 = intent.getStringExtra(MainActivity.EXTRA_TEXT3);
        String media_media_media = intent.getStringExtra(MainActivity.EXTRA_TEXT4);
        String status_status_status = intent.getStringExtra(MainActivity.EXTRA_TEXT5);

        p1 = findViewById(R.id.nota_p1);
        p1.setText(nota_11);

        p2 = findViewById(R.id.nota_p2);
        p2.setText(nota_22);

        p3 = findViewById(R.id.nota_p3);
        p3.setText(nota_33);

        nome = findViewById(R.id.nome);

        media = findViewById(R.id.nota_media);
        media.setText(media_media_media);

        status = findViewById(R.id.status_final);
        status.setText(status_status_status);

        disciplina = findViewById(R.id.disciplina);

        faltas = findViewById(R.id.faltas);

        resultado_final = findViewById(R.id.resultado_final);

        anteriorTela = findViewById(R.id.voltar);
        anteriorTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void finalizar (View view) {
        String nomePessoa = String.valueOf(nome.getText());
        String status_f = String.valueOf(status.getText());
        String disci = String.valueOf(disciplina.getText());
        String p1_final = String.valueOf(p1.getText());
        String p2_final = String.valueOf(p2.getText());
        String p3_final = String.valueOf(p3.getText());
        String media_final = String.valueOf(media.getText());
        String faltas_final = String.valueOf(faltas.getText());
        resultado_final.setText("O(A) aluno(a) " + nomePessoa + " foi " + status_f + " com a média de " + media_final + " em " + disci + " com as notas: P1=" + p1_final + ", P2=" + p2_final + ", P3=" + p3_final + " e " + faltas_final + " faltas!");
    }

    public void compartilhar (View view) {
        String result = resultado_final.getText().toString();
        Intent sendIntent = new Intent();
        sendIntent.setAction(sendIntent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(sendIntent.EXTRA_TEXT, "" + result);
        startActivity(sendIntent);
    }
}