package com.rideshare.exceptions;

public class InsufficientFundsException extends Error {
    public InsufficientFundsException(String message) {
        super(message);
    }
}
