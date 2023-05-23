package com.example.myphonesensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvSensor = (TextView) findViewById(R.id.tvSensor);
        SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List <Sensor> sensorList = sm.getSensorList(Sensor.TYPE_ALL);

        String sensorInfo = "";
        sensorInfo = "센서의 개수: " + sensorList.size() + "\n\n";
        int i = 1;
        for(Sensor s: sensorList) {
            sensorInfo = sensorInfo + i++ + "\nName: " + s.getName() + "\n해상도: "
                    + s.getResolution() + "\n최대범위:" + s.getMaximumRange() + "\n\n";
        }
        tvSensor.setText(sensorInfo);
    }
}