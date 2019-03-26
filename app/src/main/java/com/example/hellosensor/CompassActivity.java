package com.example.hellosensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sMan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        SensorManager sMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mField = sMan.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sMan.registerListener(this, mField, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing for now
    }
}
