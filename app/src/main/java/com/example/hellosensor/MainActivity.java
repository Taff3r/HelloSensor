package com.example.hellosensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Starts the AccelActivity
     * @param v, the view
     */
    public void startAccel(View v){
        Intent start = new Intent(this, AccelActivity.class);
        startActivity(start);
    }

    /**
     * Starts the CompassActivity
     * @param v, the view
     */
    public void startCompass(View v){
        Intent start = new Intent(this, CompassActivity.class);
        startActivity(start);
    }
}
