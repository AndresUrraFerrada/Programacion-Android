package com.andresurra.andres_urra_prueba_2;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.andresurra.andres_urra_prueba_2.db.dbSensores;
import com.andresurra.andres_urra_prueba_2.entidades.sensores;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class EditarActivity extends AppCompatActivity {

    EditText txtNombre, txtValor, txtFecha, txtObservacion;
    Button btnGuardar;
    FloatingActionButton fabEditar, fabEliminar;
    boolean correcto = false;
    com.andresurra.andres_urra_prueba_2.entidades.sensores sensores;

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
        fabEditar.setVisibility(View.INVISIBLE);
        fabEliminar = findViewById(R.id.fabEliminar);
        fabEliminar.setVisibility(View.INVISIBLE);

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

        dbSensores dbSensores = new dbSensores(EditarActivity.this);
        sensores = dbSensores.versensores(id);

        if(sensores != null){
            txtNombre.setText(sensores.getNombre());
            txtValor.setText(sensores.getValor());
            txtFecha.setText(sensores.getFecha());
            txtObservacion.setText(sensores.getObservacion());

        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtNombre.getText().toString().equals("")){
                    correcto = dbSensores.editarSensor(id,txtNombre.getText().toString(),txtValor.getText().toString(),txtFecha.getText().toString(),txtObservacion.getText().toString());

                    if(correcto){
                        Toast.makeText(EditarActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_SHORT).show();
                        verRegistro();
                    }else{
                        Toast.makeText(EditarActivity.this,"ERROR AL MODIFICAR", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(EditarActivity.this,"DEBE LLENAR LOS CAMPOS OBLIGATORIO", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void verRegistro(){
        Intent intent = new Intent(this, verActivity.class);
        intent.putExtra("ID",id);
        startActivity(intent);
    }
}