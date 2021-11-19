package com.andresurra.andres_urra_prueba_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.andresurra.andres_urra_prueba_2.db.dbSensores;

public class nuevoActivity2 extends AppCompatActivity {

    EditText txtnombre, txtvalor, txtfecha, txtobservacion;
    Button btn_guardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo2);

        txtnombre = findViewById(R.id.txt_nombre);
        txtvalor = findViewById(R.id.txt_valor);
        txtfecha = findViewById(R.id.txt_fecha);
        txtobservacion = findViewById(R.id.txt_observacion);
        btn_guardar = findViewById(R.id.btn_guardar);

        btn_guardar.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {

                dbSensores dbSensores = new dbSensores(nuevoActivity2.this);
                long id = dbSensores.insertarSensor(txtnombre.getText().toString(), txtvalor.getText().toString(),txtfecha.getText().toString(),txtobservacion.getText().toString());

                if( id > 0){

                    Toast.makeText(nuevoActivity2.this,"Registro Guardado", Toast.LENGTH_LONG).show();
                    limpiar();

                }else{
                    Toast.makeText(nuevoActivity2.this,"Error al guardar", Toast.LENGTH_LONG).show();

                }


            }
        });
    }

    private void limpiar(){
        txtnombre.setText("");
        txtvalor.setText("");
        txtfecha.setText("");
        txtobservacion.setText("");
    }


}