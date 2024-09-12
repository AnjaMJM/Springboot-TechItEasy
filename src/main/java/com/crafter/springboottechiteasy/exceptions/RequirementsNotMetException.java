package com.crafter.springboottechiteasy.exceptions;

public class RequirementsNotMetException extends RuntimeException {

    public RequirementsNotMetException() {
        super("The requirements are not met");
    }

    public RequirementsNotMetException(String message) {
        super(message);
    }
}
