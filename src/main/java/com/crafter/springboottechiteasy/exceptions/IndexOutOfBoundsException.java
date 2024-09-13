package com.crafter.springboottechiteasy.exceptions;

public class IndexOutOfBoundsException extends RuntimeException {

    public IndexOutOfBoundsException() {
        super("This ID does not exist");
    }

    public IndexOutOfBoundsException(String message) {
        super(message);
    }
}
