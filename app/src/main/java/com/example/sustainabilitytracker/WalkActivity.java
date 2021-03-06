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
        Button enter = findViewById(R.id.enterWalk);
        System.out.println("hey");
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createWalk();
                System.out.println("hi");
                AlertDialog.Builder builder = new AlertDialog.Builder(WalkActivity.this);
                builder.setMessage("Total Distance Walked: " + walk.getTotalDistance() + " miles");
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
        Button back = findViewById(R.id.backWalk);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(WalkActivity.this, MainActivity.class));
                //change to the car screen and enter the information
            }
        });
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/342/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.walkView);
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
    public void createWalk() {
        EditText editText = findViewById(R.id.walkTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.walkDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        walk = new Walk("walk", time, distance);
    }
}
