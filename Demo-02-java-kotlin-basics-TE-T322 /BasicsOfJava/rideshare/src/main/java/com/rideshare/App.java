package com.rideshare;

import com.rideshare.dispatch.DispatchManager;
import com.rideshare.exceptions.DriverUnavailableException;
import com.rideshare.exceptions.InvalidRouteException;
import com.rideshare.models.Driver;
import com.rideshare.models.Ride;
import com.rideshare.models.Rider;
import com.rideshare.payments.PaymentMethod;
import com.rideshare.payments.WalletPayment;
import com.rideshare.vehicles.Sedan;
import com.rideshare.vehicles.Vehicle;

public class App 
{
    public static void main( String[] args ) {
        DispatchManager dispatch = new DispatchManager();

        Rider rider = new Rider();
        rider.addFunds(100.0f);
        dispatch.registerUser("555-0001", rider);

        Vehicle driverCar = new Sedan();
        Driver driver = new Driver();
        driver.linkedVechile = driverCar;

        dispatch.driverGoesOnline(driver);

        System.out.println("------------- Ride Request Started -------------");
        try {
            Ride myRide = dispatch.requestRide(rider, "Chandkheda", "Ranip");
            myRide.vehicle = driver.linkedVechile;
            System.out.println("Trip confirmed! Vehicle Multiplier: " + myRide.vehicle.calculateBaseMultiplier() );

            PaymentMethod myWallet = new WalletPayment();
            myWallet.processPayment(25.50);


        } catch (DriverUnavailableException | InvalidRouteException e) {
            System.out.println("RIDE ERROR: " + e.getMessage());
        }
        
        System.out.println("App Closed.");
    }
}
