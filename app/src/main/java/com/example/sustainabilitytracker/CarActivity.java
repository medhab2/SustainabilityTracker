package com.example.sustainabilitytracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    }
    public void makeRequest() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://picsum.photos/id/382/200/300";
        final ImageView imageView = (ImageView) findViewById(R.id.imageView);
        final TextView textView = (TextView) findViewById(R.id.textView2);
// Retrieves an image specified by the URL, displays it in the UI.
        ImageRequest request = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setVisibility(View.VISIBLE);
                        imageView.setImageBitmap(bitmap);
                        textView.setVisibility(View.VISIBLE);
                        textView.setText("It's running!");
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
    public void createCar() {
        EditText editText = findViewById(R.id.carTime);
        String t = editText.getText().toString();
        double time = Double.parseDouble(t);
        EditText editText1 = findViewById(R.id.carDistance);
        String d = editText1.getText().toString();
        double distance = Double.parseDouble(d);
        EditText editText2 = findViewById(R.id.carType);
        String power = editText2.getText().toString();
        EditText editText3 = findViewById(R.id.carCarpool);
        String cp = editText3.getText().toString().toLowerCase();
        boolean carpool;
        if (cp.equals("yes")) {
            carpool = true;
        } else {
            carpool = false;
        }
        car = new Car("car", time, distance, power, carpool);
        System.out.println(car.getDistance() + " " + car.getTime());
    }
}
