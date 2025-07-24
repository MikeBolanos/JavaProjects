package com.example.jdbc.summative.data.exceptions;

public class InternalErrorException extends Exception {
    public InternalErrorException(Exception e) {
        super(e);
        e.printStackTrace();
    }

    public InternalErrorException(String message) {
        super(message);
    }

    public InternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InternalErrorException() {
        super(new Exception("Database error."));
    }
}
