package com.neroandnero.cea.dominio;

public record ProjectId(String value) {
    public ProjectId {
        if (value == null || value.isBlank()) {
            throw new InvalidProjectIdException("El ID del proyecto no puede estar vacío");
        }
        value = value.trim(); // Normaliza quitando espacios
    }
}