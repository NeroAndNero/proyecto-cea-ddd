package com.neroandnero.cea.dominio;

import java.time.LocalDate;

public record CreateProjectCommand(
    String id,
    String name,
    LocalDate startDate,
    LocalDate endDate,
    String promoterId
) {}