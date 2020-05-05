package com.example.sustainabilitytracker;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

public class CarActivity extends AppCompatActivity {
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        makeRequest();
        Button enter = findViewById(R.id.enterCar);
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createCar();
                AlertDialog.Builder builder = new AlertDialog.Builder(CarActivity.this);
                builder.setMessage("Total Distance Driven: " + car.getCarDistance() + " miles");
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create().show();
            }
        });
        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(CarActivity.this, MainActivity.class));
                //change to the car screen and enter the information
            }
        });
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/382/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.carView);
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
    public void createCar() {
        EditText editText = findViewById(R.id.carTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.carDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        car = new Car("car", time, distance);
    }
}
