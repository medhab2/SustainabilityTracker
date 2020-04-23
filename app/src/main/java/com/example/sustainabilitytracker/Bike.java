package com.example.sustainabilitytracker;

public class Bike extends Transportation {
    public Bike(String setType, double setTime, double setDistance) {
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
    public double getTime() {
        return super.getTime();
    }

    @Override
    public double getTotalDistance() {
        return super.getTotalDistance();
    }
}
