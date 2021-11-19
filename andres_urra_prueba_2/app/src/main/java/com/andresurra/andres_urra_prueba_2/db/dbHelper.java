package com.andresurra.andres_urra_prueba_2.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.andresurra.andres_urra_prueba_2.MainActivity;

public class dbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "sensores.db";
    public static final String TABLE_SENSORES = "sensores";

    public dbHelper(@Nullable Context context) {
        super(context,DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_SENSORES + "("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombre_sensor TEXT NOT NULL,"+
                "valor_sensor TEXT NOT NULL,"+
                "fecha TEXT NOT NULL,"+
                "observaciones TEXT NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_SENSORES);
        onCreate(sqLiteDatabase);
    }
}
