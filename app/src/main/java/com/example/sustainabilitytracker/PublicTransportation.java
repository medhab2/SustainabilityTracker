package com.example.sustainabilitytracker;

public class PublicTransportation extends Transportation {
    private boolean isBus;
    private boolean isTrain;
    private boolean isPlane;
    private static double busDistance = 0;
    private static double planeDistance = 0;
    private static double trainDistance = 0;
    public PublicTransportation(String setType, double setTime, double setDistance) {
        super(setType, setTime, setDistance);
        publicType(setType);
        if (setType.equals("bus")) {
            busDistance += setDistance;
        } else if (setType.equals("plane")) {
            planeDistance += setDistance;
        } else if (setType.equals("train")) {
            trainDistance += setDistance;
        }
    }
    public void publicType(String type) {
        if (type.equals("bus")) {
            isBus = true;
            isTrain = false;
            isPlane = false;
        } else if (type.equals("train")) {
            isTrain = true;
            isPlane = false;
            isBus = false;
        } else if (type.equals("airplane")) {
            isPlane = true;
            isTrain = false;
            isBus = false;
        } else {
            isBus = false;
            isTrain = false;
            isPlane = false;
            System.out.println("Please enter a valid Public Transportation type");
        }
    }
    public double getBusDistance() {
        return busDistance;
    }
    public double getPlaneDistance() {
        return planeDistance;
    }
    public double getTrainDistance() {
        return trainDistance;
    }
}