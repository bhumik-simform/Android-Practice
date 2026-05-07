package com.rideshare.models;
public abstract class Account {
    protected String name;
    protected String phoneNumber;
    protected double rating; // Changed from String so you can calculate averages
    protected String locationCordinates;

    public abstract void updateLocation(String newLocation);
    public abstract void getProfile();

    public String getPhoneNumber() {
        return phoneNumber;
    }
}