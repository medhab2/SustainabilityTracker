package com.example.sustainabilitytracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class BikeActivity extends AppCompatActivity {
    private Bike bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        makeRequest();
        Button enter = findViewById(R.id.enterBike);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createBike();
                AlertDialog.Builder builder = new AlertDialog.Builder(BikeActivity.this);
                builder.setMessage("Total Distance Biked: " + bike.getTotalDistance() + " miles");
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create().show();
            }
        });
        Button back = findViewById(R.id.backBike);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(BikeActivity.this, MainActivity.class));
                //change to the car screen and enter the information
            }
        });
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/1077/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.bikeView);
// Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageBitmap(bitmap);
                    }
                }, 200,300, null,
                null);
        queue.add(request);
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
