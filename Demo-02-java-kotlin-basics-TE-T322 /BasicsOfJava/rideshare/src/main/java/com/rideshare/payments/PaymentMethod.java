package com.rideshare.payments;

public interface PaymentMethod {
    boolean processPayment(double amount);
}