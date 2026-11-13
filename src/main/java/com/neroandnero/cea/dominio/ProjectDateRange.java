package com.neroandnero.cea.dominio;

import java.time.LocalDate;

public record ProjectDateRange(LocalDate startDate, LocalDate endDate) {
    public ProjectDateRange {
        if (startDate == null || endDate == null) {
            throw new InvalidProjectDateRangeException("Las fechas de inicio y fin son obligatorias");
        }
        if (endDate.isBefore(startDate)) {
            throw new InvalidProjectDateRangeException("La fecha de fin no puede ser anterior a la de inicio");
        }
    }
}