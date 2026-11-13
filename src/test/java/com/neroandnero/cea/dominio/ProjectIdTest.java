package com.neroandnero.cea.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectIdTest {

    @Test
    void shouldThrowExceptionWhenIdIsEmpty() {
        // Verifica que lanza la excepción si el ID está vacío o tiene solo espacios
        assertThrows(InvalidProjectIdException.class, () -> new ProjectId("   "));
    }

    @Test
    void shouldTrimId() {
        // Verifica que quita los espacios en los extremos
        ProjectId id = new ProjectId("  PRJ-001  ");
        assertEquals("PRJ-001", id.value());
    }
}