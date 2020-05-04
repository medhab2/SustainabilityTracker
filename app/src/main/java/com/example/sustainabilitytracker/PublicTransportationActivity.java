package com.example.sustainabilitytracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PublicTransportationActivity extends AppCompatActivity {
    private PublicTransportation transportation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_transportation);
        Button enter = findViewById(R.id.enterPublicTransit);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createTransportation();
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Total Distance Traveled: " + transportation.getTotalDistance());
                builder.setOnDismissListener(unused -> {
                    finish();
                });
                builder.create().show();
            }
        });
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
