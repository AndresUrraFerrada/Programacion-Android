package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int nClicks = 0;
    private TextView txtContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtContador = findViewById(R.id.txtContador);
    }

    public void mostrartostada(View view){
        Log.i("INFO", "MostrarTostada");
        Toast.makeText(this,"prueba de una tostada", Toast.LENGTH_LONG).show();

    }

    public void contador(View view){

        nClicks++;
        txtContador.setText(Integer.toString(nClicks));

    }

    public void reset(View view){

        nClicks = 0;
        txtContador.setText(Integer.toString(nClicks));

    }

    public void disminuir(View view){

        nClicks--;
        txtContador.setText(Integer.toString(nClicks));

    }




}