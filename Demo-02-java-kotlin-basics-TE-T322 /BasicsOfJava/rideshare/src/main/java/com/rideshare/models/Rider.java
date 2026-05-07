package com.rideshare.models;

// import java.util.LinkedList;

import com.rideshare.exceptions.InsufficientFundsException;


public class Rider extends Account {
    private Float _walletBalance = 0.0f; 
    //LinkedList<Ride> rideHistory;

    public void addFunds(Float amount) {
        if(amount > 0) {
            _walletBalance += amount;
        }
    }

    
    public void DeductFare(Float amount) throws InsufficientFundsException {
        if(amount < 0) { return; }
        else if(amount > _walletBalance) { 
            throw new InsufficientFundsException("Not enough funds in wallet!"); 
        }
        _walletBalance -= amount;
    }

    @Override
    public void getProfile() {
        System.out.println("Name: "+ name);
        System.out.println("Phone Number: "+ phoneNumber);
        System.out.println("Rating: "+ rating);
        System.out.println("Current Location "+ locationCordinates);
    }

    @Override
    public void updateLocation(String newLocation) {
       locationCordinates = newLocation;
    }    
}