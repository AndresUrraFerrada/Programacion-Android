package com.andresurra.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    private TextView valorx;
    private TextView valory;
    private TextView valorz;
    private TextView proximidad;

    private Sensor sensorA;
    private Sensor sensorP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorx = findViewById(R.id.txt_valorx);
        valory = findViewById(R.id.txt_valory);
        valorz = findViewById(R.id.txt_valorz);
        proximidad = findViewById(R.id.txt_valorproximidad);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorA = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this,sensorA, SensorManager.SENSOR_DELAY_NORMAL);

        sensorP = (Sensor) sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this,sensorP, SensorManager.SENSOR_DELAY_NORMAL);



    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()){
            case Sensor.TYPE_ACCELEROMETER:
                valorx.setText(String.format("%f",sensorEvent.values[0]));
                valory.setText(String.format("%f",sensorEvent.values[1]));
                valorz.setText(String.format("%f",sensorEvent.values[2]));
                break;
            case Sensor.TYPE_PROXIMITY:
                proximidad.setText(String.format("%f",sensorEvent.values[0]));
                break;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}