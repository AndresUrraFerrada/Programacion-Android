package com.andresurra.andres_urra_prueba_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.andresurra.andres_urra_prueba_2.db.dbSensores;
import com.andresurra.andres_urra_prueba_2.entidades.sensores;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class verActivity extends AppCompatActivity {

    EditText txtNombre, txtValor, txtFecha, txtObservacion;
    Button btnGuardar;
    FloatingActionButton fabEditar, fabEliminar;

    sensores sensores;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtNombre = findViewById(R.id.txt_nombre);
        txtValor = findViewById(R.id.txt_valor);
        txtFecha = findViewById(R.id.txt_fecha);
        txtObservacion = findViewById(R.id.txt_observacion);
        btnGuardar = findViewById(R.id.btn_guardar);
        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);

        if(savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if(extras == null){
                id = Integer.parseInt(null);
            }else{
                id = extras.getInt("ID");
            }

        }else {
            id = (int) savedInstanceState.getSerializable("ID");

        }

        dbSensores dbSensores = new dbSensores(verActivity.this);
        sensores = dbSensores.versensores(id);

        if(sensores != null){
            txtNombre.setText(sensores.getNombre());
            txtValor.setText(sensores.getValor());
            txtFecha.setText(sensores.getFecha());
            txtObservacion.setText(sensores.getObservacion());
            btnGuardar.setVisibility(View.INVISIBLE);
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtValor.setInputType(InputType.TYPE_NULL);
            txtFecha.setInputType(InputType.TYPE_NULL);
            txtObservacion.setInputType(InputType.TYPE_NULL);
        }

        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(verActivity.this, EditarActivity.class);
                intent.putExtra("ID",id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(verActivity.this);
                builder.setMessage("¿desea eliminar este sensor?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if(dbSensores.eliminarSensor(id)){
                            lista();

                        }
                    }
                })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        }).show();
            }
        });

    }

    private void lista(){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

}