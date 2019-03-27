package com.example.hellosensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Parcel;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sMan;
    private ImageView compass;
    private float deg;
    private TextView txt;
    private Vibrator vib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        sMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor mField = sMan.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        this.compass = findViewById(R.id.imgCompass);
        this.txt = findViewById(R.id.txtDir);
        this.deg = 0f;
        this.vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sMan.registerListener(this, mField, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float degree = Math.round(event.values[0]);
        RotateAnimation ra = new RotateAnimation(-this.deg, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        ra.setDuration(200);
        ra.setFillAfter(true);
        compass.startAnimation(ra);
        this.deg = degree;
        updateTextAndVibrate();
    }

    private void updateTextAndVibrate(){
        txt.setText("Current direction:" + this.deg);

        if(this.deg >= 345 || this.deg <= 15){ // NOTE ONLY WORKS FOR SDK VERSION >= 26, ELSE APP CRASHES
            vib.vibrate(VibrationEffect.createOneShot(10, VibrationEffect.DEFAULT_AMPLITUDE));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do nothing for now
    }
}
