package com.andresurra.evaluacion11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String nombre;
    private String apellido;

    private TextView txt_nombre;
    private TextView txt_apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre = findViewById(R.id.etxt_nombre);
        txt_apellido = findViewById(R.id.etxt_apellido);

    }


    public void confirmacion(View view){

        nombre = txt_nombre.getText().toString();

        Toast.makeText(this,nombre+", Pedido Confirmado!", Toast.LENGTH_LONG).show();

    }
}