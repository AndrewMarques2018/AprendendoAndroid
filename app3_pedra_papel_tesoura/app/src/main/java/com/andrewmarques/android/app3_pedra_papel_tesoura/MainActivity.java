package com.andrewmarques.android.app3_pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int idPedra, idPapel, idTesoura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idPapel = findViewById(R.id.imgBtPapel).getId();
        idPedra = findViewById(R.id.imgBtPedra).getId();
        idTesoura = findViewById(R.id.imgBtTesoura).getId();
    }

    public void click (View view) {
        TextView txtResultado = findViewById(R.id.txtResultado);
        ImageButton imgBtMaquina = findViewById(R.id.imgBtEscolhaMaquina);

        String minhaEscolha = "", maquinaEscolha = "";

        if(view.getId() == idPapel){
            minhaEscolha = "papel";
        }else
        if(view.getId() == idPedra){
            minhaEscolha = "pedra";
        }else
        if(view.getId() == idTesoura){
            minhaEscolha = "tesoura";
        }

        int i = new Random().nextInt(4);
        if(i == 0){
            maquinaEscolha = "papel";
            imgBtMaquina.setImageResource(R.drawable.papel);
        }else
        if(i == 1){
            maquinaEscolha = "pedra";
            imgBtMaquina.setImageResource(R.drawable.pedra);
        }else
        if(i == 2){
            maquinaEscolha = "tesoura";
            imgBtMaquina.setImageResource(R.drawable.tesoura);
        }

        if(minhaEscolha.equals(maquinaEscolha)){
            txtResultado.setText("Empate");
        }else
        if(maquinaEscolha == "pedra" && minhaEscolha == "tesoura" ||
           maquinaEscolha == "papel" && minhaEscolha == "pedra" ||
           maquinaEscolha == "tesoura" && minhaEscolha == "papel"){
            txtResultado.setText("Perdeu");
        }else{
            txtResultado.setText("Ganhou");
        }
    }
}