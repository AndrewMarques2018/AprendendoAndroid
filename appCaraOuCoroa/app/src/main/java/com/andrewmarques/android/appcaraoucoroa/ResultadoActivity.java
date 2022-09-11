package com.andrewmarques.android.appcaraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ResultadoActivity extends AppCompatActivity {

    private ImageView imgResultado;
    private Button btVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        btVoltar = findViewById(R.id.btVoltar);
        setContentView(R.layout.activity_resultado);

        Bundle dados = getIntent().getExtras();
        int i = dados.getInt("numero");

        imgResultado = findViewById(R.id.imageResultado);
        if (i == 0){
            // cara
            imgResultado.setImageResource(R.drawable.cara);
        }else{
            // coroa
            imgResultado.setImageResource(R.drawable.coroa);
        }

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




}