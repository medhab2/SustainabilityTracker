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
