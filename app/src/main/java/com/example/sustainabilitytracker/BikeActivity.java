package com.example.sustainabilitytracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class BikeActivity extends AppCompatActivity {
    private Bike bike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike);
        Button enter = findViewById(R.id.enterBike);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createBike();
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Total Distance Traveled: " + bike.getTotalDistance());
                builder.setOnDismissListener(unused -> {
                    finish();
                });
                builder.create().show();
            }
        });
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/1077/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.bikeView);
        final TextView textView = (TextView) findViewById(R.id.text);
// Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageBitmap(bitmap);
                    }
                }, 200,300, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        textView.setVisibility(View.VISIBLE);
                        textView.setText(error.getMessage());
                    }
                });
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
