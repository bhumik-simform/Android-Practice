package com.rideshare.payments;

public class WalletPayment implements PaymentMethod {
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing wallet payment of: $" + amount);
        return true; 
    }
}