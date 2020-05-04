package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class BikeActivity extends AppCompatActivity {
    private Bike bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
    }
    public void createBike() {
        EditText editText = findViewById(R.id.bikeTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.bikeDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        bike = new Bike("bike", time, distance);
    }
}
