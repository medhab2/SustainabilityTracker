package com.example.sustainabilitytracker;

public class Walk extends Transportation {
    private static final double averageTime = -1;
    private static final double averageDistance = -1;
    public Walk(String setType, double setTime, double setDistance) {
        super(setType, setTime, setDistance);
    }
    public static double getAverageTime() {
        return averageTime;
    }
    public static double getAverageDistance() {
        return averageDistance;
    }
    public double getTime() {
        return super.getTime();
    }
    public double getDistance() {
        return super.getDistance();
    }
    public String getType() {
        return super.getType();
    }
}
