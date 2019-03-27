package com.example.hellosensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class AccelActivity extends AppCompatActivity implements SensorEventListener{
    private final double COLOR_SCALAR = 255/10;
    private SensorManager sensorMan;
    private Sensor sensor;
    private double x;
    private double y;
    private double z;
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
        updateUI();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing for now
    }

    private void updateUI(){
        int r = getColorValue(x);
        int g = getColorValue(y);
        int b = getColorValue(z);
        getWindow().getDecorView().setBackgroundColor(Color.rgb(r,g,b));
        this.display.setText(
                "The Values are: \n"
                        + this.x + "\n" + this.y + "\n" + this.z + "\n"
                        + "Current color (RGB): " + r + " "+ g + " " + b
        );
    }

    private int getColorValue(double value){
        return (int) (Math.abs(value) * this.COLOR_SCALAR);
    }
}
