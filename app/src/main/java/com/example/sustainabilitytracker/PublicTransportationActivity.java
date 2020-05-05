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

public class PublicTransportationActivity extends AppCompatActivity {
    private PublicTransportation transportation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_transportation);
        makeRequest("https://picsum.photos/id/694/200/300", (ImageView) findViewById(R.id.busView));
        makeRequest("https://picsum.photos/id/1026/200/300", (ImageView) findViewById(R.id.trainView));
        makeRequest("https://picsum.photos/id/364/200/300", (ImageView) findViewById(R.id.planeView));
        Button enter = findViewById(R.id.enterPublicTransit);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createTransportation();
                System.out.println("hi");
                AlertDialog.Builder builder = new AlertDialog.Builder(PublicTransportationActivity.this);
                builder.setMessage("Total Distance Travelled: " + transportation.getTotalDistance() + " miles");
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                System.out.println("yo");
                builder.create().show();
                System.out.println("lol");
            }
        });
        Button back = findViewById(R.id.backTransit);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(PublicTransportationActivity.this, MainActivity.class));
                //change to the car screen and enter the information
            }
        });
    }
    public void makeRequest(String url, ImageView imageView) {
        RequestQueue queue = Volley.newRequestQueue(this);
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
