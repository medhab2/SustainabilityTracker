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
    }
    public void createTransportation() {
        EditText editText = findViewById(R.id.publicTransitTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.publicTransitDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        EditText editText2 = findViewById(R.id.publicTransitType);
        String type = editText2.getText().toString().toLowerCase();
        transportation = new PublicTransportation(type, time, distance);
    }
}
