package com.neroandnero.cea.dominio;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProjectNameTest {

    @Test
    void shouldThrowExceptionWhenNameIsTooShort() {
        assertThrows(InvalidProjectNameException.class, () -> new ProjectName("AB"));
    }

    @Test
    void shouldTrimAndCreateValidName() {
        ProjectName name = new ProjectName("  ORION  ");
        assertEquals("ORION", name.value());
    }
}