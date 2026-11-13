package com.neroandnero.cea.dominio;

public class InvalidProjectNameException extends RuntimeException {
    public InvalidProjectNameException(String message) {
        super(message);
    }
}