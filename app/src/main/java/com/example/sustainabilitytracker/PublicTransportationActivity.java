package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class PublicTransportationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_transportation);
        EditText text = findViewById(R.id.publicTransitTime);
        String temp = text.getText().toString();
        double time = Double.parseDouble(temp);
    }
}
