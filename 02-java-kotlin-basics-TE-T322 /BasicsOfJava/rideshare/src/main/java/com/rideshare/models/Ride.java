package com.rideshare.models;

import com.rideshare.enums.RideStatus;
import com.rideshare.enums.RideType;
import com.rideshare.exceptions.InvalidRouteException;
import com.rideshare.payments.PaymentMethod;
import com.rideshare.vehicles.Vehicle;

@SuppressWarnings("unused")
public class Ride {
    Rider rider;
    Driver driver;
    public Vehicle vehicle; // Added this
    PaymentMethod paymentMethod; // Added this
    RideType rideType;
    RideStatus rideStatus;
    String pickUpLocation;
    String dropOffLocation;
    double finalFair;

    public Ride(Rider rider, Driver driver, String pickUpLocation, String dropLocation) throws InvalidRouteException {
        this.rider = rider;
        this.driver = driver;
        if (pickUpLocation.equals(dropLocation)) {
            throw new InvalidRouteException("Pickup and drop-off cannot be the exact same!");
        }
        
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropLocation;
        this.rideStatus = RideStatus.REQUESTED;
        
    }
}