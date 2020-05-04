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
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setMessage("Total Distance Traveled: " + transportation.getTotalDistance());
                builder.setOnDismissListener(unused -> {
                    finish();
                });
                builder.create().show();
            }
        });
    }
    public void makeRequest(String url, ImageView imageView) {
        RequestQueue queue = Volley.newRequestQueue(this);
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
