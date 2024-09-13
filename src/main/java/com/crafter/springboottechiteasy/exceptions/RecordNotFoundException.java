package com.crafter.springboottechiteasy.exceptions;


public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException() {
        super("No item matching your request");
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
