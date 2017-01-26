package com.example.raphi.myapplication;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.hardware.Sensor;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    public static final String TAG = "MainActivity";

    TextView xpos;
    TextView ypos;
    ProgressBar xprog;
    ProgressBar yprog;

    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        xpos = (TextView) findViewById(R.id.textview_x);
        ypos = (TextView) findViewById(R.id.textview_y);
        xprog = (ProgressBar) findViewById(R.id.progress_x);
        yprog = (ProgressBar) findViewById(R.id.progress_y);

        xprog.setMax(20);
        yprog.setMax(20);


        xprog.setProgress(50);
        yprog.setProgress(50);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);


        Log.d(TAG, "onCreate finished");


    }

//    public SensorEventListener gyroListener = new SensorEventListener() {
//        @Override
//        public void onSensorChanged(SensorEvent event) {
//            Log.d(TAG, "><<");
//            float x = event.values[0];
//            float y = event.values[1];
//            float z = event.values[2];
//
//            xpos.setText("X : " + (int)x + " rad/s");
//            ypos.setText("Y : " + (int)y + " rad/s");
//            //textZ.setText("Z : " + (int)z + " rad/s");
//        }
//
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int i) {
//
//        }
//    };

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        Sensor mySensor = sensorEvent.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];

            StringBuilder outputBuilder = new StringBuilder();

            for(int i = 0; i < sensorEvent.values.length; i++){
                outputBuilder.append(sensorEvent.values[i]+"   /   ");
            }

            Log.d(TAG, outputBuilder.toString());

            xpos.setText((x/100)+"");
            ypos.setText((y/100)+"");

            xprog.setProgress((int) x + 10);
            yprog.setProgress((int) y + 10);
        }
    };
}