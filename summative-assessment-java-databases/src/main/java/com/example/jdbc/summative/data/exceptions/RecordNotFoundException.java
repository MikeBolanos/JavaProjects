package com.example.jdbc.summative.data.exceptions;

public class RecordNotFoundException extends Exception  {

    public RecordNotFoundException(String message) {
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
