package com.example.sustainabilitytracker;

public class PublicTransportation extends Transportation {
    private boolean isBus;
    private boolean isTrain;
    private boolean isPlane;
    public PublicTransportation(String setType, double setTime, double setDistance) {
        super(setType, setTime, setDistance);
        publicType(setType);
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
}