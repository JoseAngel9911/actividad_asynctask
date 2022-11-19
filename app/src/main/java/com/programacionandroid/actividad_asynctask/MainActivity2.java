package com.programacionandroid.actividad_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvResultado = (TextView)findViewById(R.id.txtResultado);
        String nombreUsuario = getIntent().getStringExtra("usuario");
        tvResultado.setText("Bienvenido: " + nombreUsuario);
    }
}