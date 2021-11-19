package com.andresurra.andres_urra_prueba_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andresurra.andres_urra_prueba_2.adaptador.ListaSensoresAdapter;
import com.andresurra.andres_urra_prueba_2.db.dbHelper;
import com.andresurra.andres_urra_prueba_2.db.dbSensores;
import com.andresurra.andres_urra_prueba_2.entidades.sensores;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listasensores;
    ArrayList<sensores> listaArraySensores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listasensores = findViewById(R.id.lista_sensores);
        listasensores.setLayoutManager(new LinearLayoutManager(this));

        dbSensores dbSensores = new dbSensores(MainActivity.this);

        listaArraySensores = new ArrayList<>();

        ListaSensoresAdapter adapter = new ListaSensoresAdapter(dbSensores.mostrarsensores());

        listasensores.setAdapter(adapter);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pincipal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case  R.id.menu_nuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private  void nuevoRegistro(){
        Intent intent = new Intent(this,nuevoActivity2.class);
        startActivity(intent);

    }

}