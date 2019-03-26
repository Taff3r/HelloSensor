package com.example.hellosensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class AccelActivity extends AppCompatActivity {
    private SensorManager sensorMan;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);
        this.sensorMan = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        this.sensor = sensorMan.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
    }



}
