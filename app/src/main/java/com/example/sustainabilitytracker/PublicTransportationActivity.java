package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class PublicTransportationActivity extends AppCompatActivity {
    private PublicTransportation transportation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_transportation);

        EditText text = findViewById(R.id.publicTransitTime);
        String temp = text.getText().toString();
        double time = Double.parseDouble(temp);
        EditText text1 = findViewById(R.id.publicTransitDistance);
        String tmp = text1.getText().toString();
        double distance = Double.parseDouble(tmp);
        EditText text2 = findViewById(R.id.publicTransitType);
        String type = text2.getText().toString();
        transportation = new PublicTransportation(type, time, distance);
    }
}
