package com.neroandnero.cea.dominio;

public record ProjectName(String value) {
    public ProjectName {
        if (value == null || value.isBlank()) {
            throw new InvalidProjectNameException("El nombre no puede estar vacío");
        }
        value = value.trim();
        if (value.length() < 3) {
            throw new InvalidProjectNameException("El nombre debe tener al menos 3 caracteres");
        }
    }
}