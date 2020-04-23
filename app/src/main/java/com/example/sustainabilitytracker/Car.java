package com.example.sustainabilitytracker;

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
}
