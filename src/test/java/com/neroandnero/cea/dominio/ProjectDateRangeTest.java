package com.neroandnero.cea.dominio;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProjectDateRangeTest {

    @Test
    void shouldThrowExceptionWhenEndDateIsBeforeStartDate() {
        LocalDate inicio = LocalDate.of(2026, 2, 1);
        LocalDate fin = LocalDate.of(2026, 1, 1); // Inválido
        
        assertThrows(InvalidProjectDateRangeException.class, () -> new ProjectDateRange(inicio, fin));
    }

    @Test
    void shouldCreateValidDateRange() {
        LocalDate inicio = LocalDate.of(2026, 1, 1);
        LocalDate fin = LocalDate.of(2026, 2, 1);
        
        ProjectDateRange rango = new ProjectDateRange(inicio, fin);
        assertEquals(inicio, rango.startDate());
        assertEquals(fin, rango.endDate());
    }
}