package com.neroandnero.cea.dominio;

public class InvalidProjectDateRangeException extends RuntimeException {
    public InvalidProjectDateRangeException(String message) {
        super(message);
    }
}