package com.rideshare.dispatch;


import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.rideshare.exceptions.DriverUnavailableException;
import com.rideshare.exceptions.InvalidRouteException;
import com.rideshare.models.Account;
import com.rideshare.models.Driver;
import com.rideshare.models.Ride;
import com.rideshare.models.Rider;


public class DispatchManager {
    Map<String, Account> Map = new HashMap<>();
    private final ArrayList<Driver> availableDrivers = new ArrayList<>();

    public void registerUser(String phoneNumber, Account user) {
        if(Map.containsKey(phoneNumber) ) {
            System.err.println("User with "+ phoneNumber +" already exists.");
        }
        Map.put(phoneNumber, user);
        System.out.println("User registered successfully.");
    }

    public void driverGoesOnline(Driver driver) {
        availableDrivers.add(driver);
        System.out.println("A driver is now online and waiting for a ride!");
    }

    public Ride requestRide(Rider rider, String pickup, String dropoff) throws InvalidRouteException, DriverUnavailableException {
        if (availableDrivers.isEmpty()) {
            throw new DriverUnavailableException("There is no current Driver avaiable try after a while!");
        }
        Driver currDriver = availableDrivers.get(0);
        availableDrivers.remove(currDriver);
        Ride newRide = new Ride(rider, currDriver, pickup, dropoff);

        System.out.println("Ride matched successfully! Driver is on the way.");
        return newRide;
    }

}
