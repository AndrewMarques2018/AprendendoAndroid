package com.andrewmarques.android.primeiroapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void sortear (View view) {
        int x;
        x = (int) (Math.random() * 10);
        TextView textView = findViewById(R.id.txtResultado);
        textView.setText("O numero selecionado foi :" + x);
    }

}