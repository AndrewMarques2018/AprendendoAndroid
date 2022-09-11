package com.andrewmarques.android.appcaraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btJogar = findViewById(R.id.btJogar);

        btJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);
                int numRand = new Random().nextInt(2);
                intent.putExtra("numero", numRand);
                startActivity(intent);
            }
        });
    }

    public void trocarTela (View view){
        Intent intent = new Intent(getApplicationContext(), ResultadoActivity.class);

        int numRand = new Random().nextInt(2);
        intent.putExtra("numero", numRand);

        startActivity(intent);
    }
}