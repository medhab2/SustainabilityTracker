package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class WalkActivity extends AppCompatActivity {
    private Walk walk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);
    }
    public void createWalk() {
        EditText editText = findViewById(R.id.walkTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.walkDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        walk = new Walk("bike", time, distance);
    }
}
