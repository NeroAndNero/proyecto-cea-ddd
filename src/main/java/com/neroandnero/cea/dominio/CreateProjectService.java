package com.neroandnero.cea.dominio;

public class CreateProjectService {

    private final GetProjectByIdPort getProjectByIdPort;
    private final SaveProjectPort saveProjectPort;

    // Inyección de dependencias por constructor
    public CreateProjectService(GetProjectByIdPort getProjectByIdPort, SaveProjectPort saveProjectPort) {
        this.getProjectByIdPort = getProjectByIdPort;
        this.saveProjectPort = saveProjectPort;
    }

    public ProjectModel execute(CreateProjectCommand command) {
        // 1. Construir los Value Objects (esto valida automáticamente)
        ProjectId id = new ProjectId(command.id());
        ProjectName name = new ProjectName(command.name());
        ProjectDateRange dateRange = new ProjectDateRange(command.startDate(), command.endDate());

        // 2. Verificar si ya existe (usando el Puerto)
        if (getProjectByIdPort.getById(id).isPresent()) {
            throw new ProjectAlreadyExistsException("El proyecto con ID " + id.value() + " ya existe.");
        }

        // 3. Crear la entidad usando el Factory (que asigna estado PLANNED)
        ProjectModel newProject = ProjectModel.create(id, name, dateRange, command.promoterId());

        // 4. Guardar (usando el Puerto)
        saveProjectPort.save(newProject);

        // 5. Retornar el proyecto creado
        return newProject;
    }
}