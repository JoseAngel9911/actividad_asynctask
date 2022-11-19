package com.programacionandroid.actividad_asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button btnValidar;
    private EditText etUsuario, etClave;
    private ProgressBar progressBar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnValidar = (Button) findViewById(R.id.btnValidar);
        etUsuario = (EditText) findViewById(R.id.cptxtUsuario);
        etClave = (EditText) findViewById(R.id.cptxtClave);
        progressBar1 = (ProgressBar) findViewById(R.id.progressBar);

        btnValidar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Taks1().execute(etUsuario.getText().toString());
            }
        });
    }

    class Taks1 extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            progressBar1.setVisibility(View.VISIBLE);
            btnValidar.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            progressBar1.setVisibility(View.INVISIBLE);
            btnValidar.setEnabled(true);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("usuario", etUsuario.getText().toString());
            startActivity(intent);
        }
    }
}