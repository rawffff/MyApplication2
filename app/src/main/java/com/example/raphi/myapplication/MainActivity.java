package com.example.raphi.myapplication;

import android.hardware.SensorEvent;
import android.icu.util.Output;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.hardware.Sensor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Start;
        Start = (Button) findViewById(R.id.button_go);

        Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView Ausgabe;
                Ausgabe = (TextView) findViewById(R.id.textview_output);

                TextView xpos;
                xpos = (TextView) findViewById(R.id.textview_x);

                TextView ypos;
                ypos = (TextView) findViewById(R.id.textview_y);

                ProgressBar xprog;
                xprog = (ProgressBar) findViewById(R.id.progress_x);

                ProgressBar yprog;
                yprog = (ProgressBar) findViewById(R.id.progress_y);

                xprog.setMax(100);
                yprog.setMax(100);


                Ausgabe.setText("Messung läuft");

                xpos.setText("...");
                ypos.setText("...");

                xprog.setProgress(50);
                yprog.setProgress(50);


               /* @Override
                public void onSensorChanged(SensorEvent sensorEvent)
                {
                    Sensor mySensor = sensorEvent.sensor;

                    if (mySensor.getType() == Sensor.TYPE_GYROSCOPE) {
                        float x = sensorEvent.values[0];
                        float y = sensorEvent.values[1];

                        xpos.setText(x);
                        ypos.setText(y);

                        xprog.setProgress(50);
                        yprog.setProgress(50);
                    }
                };*/


            }
        });

    }
}