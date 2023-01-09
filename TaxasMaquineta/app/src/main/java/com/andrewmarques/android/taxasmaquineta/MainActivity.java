package com.andrewmarques.android.taxasmaquineta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout total_proc;
    private TextView txt_av, txt_d, txt_x1, txt_x2, txt_x3, txt_x4, txt_x5, txt_x10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total_proc = findViewById(R.id.txtl_total_proc);

        txt_av = findViewById(R.id.txt_av);
        txt_d = findViewById(R.id.txt_d);
        txt_x1 = findViewById(R.id.txt_x1);
        txt_x2 = findViewById(R.id.txt_x2);
        txt_x3 = findViewById(R.id.txt_x3);
        txt_x4 = findViewById(R.id.txt_x4);
        txt_x5 = findViewById(R.id.txt_x5);
        txt_x10 = findViewById(R.id.txt_x10);

    }

    public void calcularProc (View view) {

        try {
            Double proc = Double.parseDouble(String.valueOf(total_proc.getEditText().getText()));
            Double av, d, x1, x2, x3, x4, x5, x10;

            av = proc;
            d = proc * (1 + 0.0199 + 0.0004);  // 102.03 : 1.99        + 0.04
            x1 = proc * (1 + 0.0498 + 0.0026);  // 105.24 : 4.98        + 0.26
            x2 = proc * (1 + 0.0459 + 0.0531 + 0.0109);  // 110.99 : 4.59 + 5.31 + 1.09
            x3 = proc * (1 + 0.0597 + 0.0531 + 0.0143);  // 112.71 : 5.97 + 5.31 + 1.43
            x4 = proc * (1 + 0.0733 + 0.0531 + 0.0183);  // 114.47 : 7.33 + 5.31 + 1.83
            x5 = proc * (1 + 0.0866 + 0.0531 + 0.0227);  // 116.24 : 8.66 + 5.31 + 2.27
            x10 = proc * (1 + 0.1493 + 0.0531 + 0.0514);  // 125.38 : 14.93 + 5.31 + 5.14

            txt_av.setText(String.format("Avista: %.2f", av));
            txt_d.setText(String.format("Débito: %.2f", d));
            txt_x1.setText(String.format("Crédito 1x: %.2f", x1));
            txt_x2.setText(String.format("Crédito 2x: %.2f = %.2f", x2 / 2, x2));
            txt_x3.setText(String.format("Crédito 3x: %.2f = %.2f", x3 / 3, x3));
            txt_x4.setText(String.format("Crédito 4x: %.2f = %.2f", x4 / 4, x4));
            txt_x5.setText(String.format("Crédito 5x: %.2f = %.2f", x5 / 5, x5));
            txt_x10.setText(String.format("Crédito 10x: %.2f = %.2f", x10 / 10, x10));

        } catch (Exception e) {
            txt_av.setText(String.format("Avista:"));
            txt_d.setText(String.format("Débito:"));
            txt_x1.setText(String.format("Crédito 1x"));
            txt_x2.setText(String.format("Crédito 2x:"));
            txt_x3.setText(String.format("Crédito 3x:"));
            txt_x4.setText(String.format("Crédito 4x:"));
            txt_x5.setText(String.format("Crédito 5x:"));
            txt_x5.setText(String.format("Crédito 10x:"));
        }
    }
}