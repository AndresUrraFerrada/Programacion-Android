package com.andresurra.andres_urra_prueba_2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.andresurra.andres_urra_prueba_2.entidades.sensores;

import java.util.ArrayList;

public class dbSensores extends dbHelper{


    Context context;

    public dbSensores(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarSensor(String nombre, String valor, String fecha, String observacion){

        long id = 0;

        try {
            dbHelper dbHelper = new dbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre_sensor", nombre);
            values.put("valor_sensor", valor);
            values.put("fecha", fecha);
            values.put("observaciones", observacion);

            id = db.insert(TABLE_SENSORES, null, values);

        }catch(Exception ex){
            ex.toString();
        }

        return id;

    }

    public ArrayList<sensores> mostrarsensores(){
        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<sensores> listasensores = new ArrayList<>();
        sensores sensores = null;
        Cursor cursorsensores = null;

        cursorsensores = db.rawQuery("SELECT * FROM "+ TABLE_SENSORES, null);

        if(cursorsensores.moveToFirst()){
            do{
                sensores = new sensores();
                sensores.setId(cursorsensores.getInt(0));
                sensores.setNombre(cursorsensores.getString(1));
                sensores.setValor(cursorsensores.getString(2));
                sensores.setFecha(cursorsensores.getString(3));
                sensores.setObservacion(cursorsensores.getString(4));

                listasensores.add(sensores);

            } while(cursorsensores.moveToNext());
        }

        cursorsensores.close();

        return listasensores;
    }

    public sensores versensores(int id){
        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        sensores sensores = null;
        Cursor cursorsensores;

        cursorsensores = db.rawQuery("SELECT * FROM "+ TABLE_SENSORES+" WHERE id = " + id + " LIMIT 1", null);

        if(cursorsensores.moveToFirst()){
                sensores = new sensores();
                sensores.setId(cursorsensores.getInt(0));
                sensores.setNombre(cursorsensores.getString(1));
                sensores.setValor(cursorsensores.getString(2));
                sensores.setFecha(cursorsensores.getString(3));
                sensores.setObservacion(cursorsensores.getString(4));

        }

        cursorsensores.close();

        return sensores;
    }

    public boolean editarSensor(int id, String nombre, String valor, String fecha, String observacion){

        boolean correcto = false;

        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_SENSORES + " SET nombre_sensor = '" + nombre + "', valor_sensor = '" + valor + "', fecha = '" + fecha + "', observaciones = '" + observacion + "' WHERE id='" + id + "' ");
            correcto = true;


        }catch(Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }

        return correcto;

    }

    public boolean eliminarSensor(int id){

        boolean correcto = false;

        dbHelper dbHelper = new dbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM "+ TABLE_SENSORES + " WHERE id = '" + id + "'");
            correcto = true;


        }catch(Exception ex){
            ex.toString();
            correcto = false;
        }finally {
            db.close();
        }

        return correcto;

    }
}
