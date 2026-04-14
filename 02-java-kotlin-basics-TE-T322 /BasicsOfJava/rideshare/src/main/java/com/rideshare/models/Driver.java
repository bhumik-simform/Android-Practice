package com.rideshare.models;

// import java.util.LinkedList;

import com.rideshare.vehicles.Vehicle;

public class Driver extends Account {
    public Boolean currentAvaibility;
    public Vehicle linkedVechile; 
    // LinkedList<Ride> rideHistory;

    @Override
    public void getProfile() {
        System.out.println("Name: "+ name);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.println("Rating: "+ rating);
        System.out.println("Current Location: "+ locationCordinates);
        System.out.println("Avaible: "+ (currentAvaibility != null && currentAvaibility ? "Yes" : "No"));
    }
    
    @Override
    public void updateLocation(String newLocation) {
        locationCordinates = newLocation;
    }
}