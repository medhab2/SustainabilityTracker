package com.example.sustainabilitytracker;

public class Transportation {
    private String type;
    private double time;
    private double distance;
    private static double totalDistance = 0;
    public Transportation(String setType, double setTime, double setDistance) {
        type = setType;
        time = setTime;
        distance = setDistance;
        totalDistance += distance;

    }
    public boolean ifCar(String type) {
        if (type.equals("car")) {
            //make a pop up and ask them what kind of car
            return true;
        } else {
            return false;
        }
    }
    public String getType() {
        return type;
    }
    public double getTime() {
        //need to change units depending on how the user inputs it
        return time;
    }
    public double getDistance() {
        return distance;
    }
    public double getTotalDistance() {
        return totalDistance;
    }
}
