package com.luxeserve.rating_service.exceptions;

public class ResourceNotFound extends RuntimeException{
    // Constructor to accept a custom message
    public ResourceNotFound(String message) {
        super(message);
    }

    // Default constructor with a default message
    public ResourceNotFound() {
        super("Resource not found on server");
    }
}
