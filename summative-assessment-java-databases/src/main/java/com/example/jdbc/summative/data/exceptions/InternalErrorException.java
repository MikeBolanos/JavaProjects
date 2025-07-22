package com.example.jdbc.summative.data.exceptions;

public class InternalErrorException extends Exception {
    public InternalErrorException(Exception e) {
        super(e);
        e.printStackTrace();
    }

    public InternalErrorException() {
        super(new Exception("Database error."));
    }
}
