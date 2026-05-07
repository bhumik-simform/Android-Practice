package com.rideshare.exceptions;

public class NoDriversAvailableException extends Error {

    public NoDriversAvailableException(String message) {
        super(message);
    }
}
