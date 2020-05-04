package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class WalkActivity extends AppCompatActivity {
    private Walk walk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk);
        makeRequest();
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/342/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.walkView);
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
