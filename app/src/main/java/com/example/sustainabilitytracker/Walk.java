package com.example.sustainabilitytracker;

import androidx.annotation.Nullable;

public class Walk extends Transportation {
    public Walk(String setType, double setTime, double setDistance) {
        super(setType, setTime, setDistance);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public boolean ifCar(String type) {
        return super.ifCar(type);
    }

    @Override
    public double getDistance() {
        return super.getDistance();
    }

    @Override
    public double getTotalDistance() {
        return super.getTotalDistance();
    }

    @Override
    public double getTime() {
        return super.getTime();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
