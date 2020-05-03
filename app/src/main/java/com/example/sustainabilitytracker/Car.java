package com.example.sustainabilitytracker;

import android.widget.TextView;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

public class Car extends Transportation {
    private String power;
    private boolean carPool;
    private double carDistance = 0;
    public Car(String setType, double setTime, double setDistance, String setPower, boolean setCarPool) {
        super(setType, setTime, setDistance);
        power = setPower;
        carPool = setCarPool;
        carDistance += setDistance;
    }
    public boolean didCarpool() {
        return carPool;
    }
    public String getPower() {
        return power;
    }
    public double getCarDistance() {
        return carDistance;
    }

    @Override
    public double getTime() {
        return super.getTime();
    }

    @Override
    public double getTotalDistance() {
        return super.getTotalDistance();
    }

    @Override
    public double getDistance() {
        return super.getDistance();
    }

    @Override
    public boolean ifCar(String type) {
        return super.ifCar(type);
    }

    @Override
    public String getType() {
        return super.getType();
    }


}
