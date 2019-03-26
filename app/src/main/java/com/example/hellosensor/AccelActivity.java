package com.example.hellosensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class AccelActivity extends AppCompatActivity implements SensorEventListener{
    private SensorManager sensorMan;
    private Sensor sensor;
    private double x;
    private double y;
    private double z;
    private double abs;
    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accel);
        this.sensorMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        this.sensor = sensorMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorMan.registerListener(this, this.sensor, SensorManager.SENSOR_DELAY_NORMAL);
        this.display =  findViewById(R.id.txtValues);
    }

    @Override
    public void onSensorChanged(SensorEvent e) {
        this.x = e.values[0];
        this.y = e.values[1];
        this.z = e.values[2];
        this.abs = Math.sqrt(x*x + y*y + z*z);
        updateText();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing for now
    }

    private void updateText(){
        this.display.setText(
                "The Values are: \n"
                + this.x + "\n" + this.y + "\n" + this.z + "\n"
                + "Diagonal :" + this.abs
        );
    }
}
