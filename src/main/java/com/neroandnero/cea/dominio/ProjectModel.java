package com.neroandnero.cea.dominio;

public record ProjectModel(
    ProjectId id,
    ProjectName name,
    ProjectDateRange dateRange,
    ProjectStatus status,
    String promoterId
) {
    // Método Factory para asegurar que nace en PLANNED (como en tu pseudocódigo)
    public static ProjectModel create(ProjectId id, ProjectName name, ProjectDateRange dateRange, String promoterId) {
        if (promoterId == null || promoterId.isBlank()) {
            throw new IllegalArgumentException("El ID del promotor es obligatorio");
        }
        return new ProjectModel(id, name, dateRange, ProjectStatus.PLANNED, promoterId);
    }

    // Métodos de negocio que devuelven una NUEVA instancia con el estado cambiado
    public ProjectModel start() {
        return new ProjectModel(this.id, this.name, this.dateRange, ProjectStatus.IN_PROGRESS, this.promoterId);
    }

    public ProjectModel finish() {
        return new ProjectModel(this.id, this.name, this.dateRange, ProjectStatus.FINISHED, this.promoterId);
    }
}