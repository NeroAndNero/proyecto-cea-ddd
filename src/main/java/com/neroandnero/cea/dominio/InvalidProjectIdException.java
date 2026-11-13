package com.neroandnero.cea.dominio;

public class InvalidProjectIdException extends RuntimeException {
    public InvalidProjectIdException(String message) {
        super(message);
    }
}