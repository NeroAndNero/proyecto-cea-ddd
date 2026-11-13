package com.neroandnero.cea.dominio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateProjectServiceTest {

    @Mock
    private GetProjectByIdPort getProjectByIdPort;

    @Mock
    private SaveProjectPort saveProjectPort;

    @InjectMocks
    private CreateProjectService service;

    @Test
    void shouldThrowExceptionWhenProjectAlreadyExists() {
        // Arrange (Preparar el escenario)
        CreateProjectCommand command = new CreateProjectCommand(
                "PRJ-001", "ORION", LocalDate.now(), LocalDate.now().plusDays(5), "PROM-1"
        );
        
        // Simulamos que la base de datos ya tiene un proyecto con ese ID
        ProjectModel existingProject = ProjectModel.create(
                new ProjectId("PRJ-001"), new ProjectName("VIEJO"), 
                new ProjectDateRange(LocalDate.now(), LocalDate.now()), "PROM-2"
        );
        when(getProjectByIdPort.getById(any(ProjectId.class))).thenReturn(Optional.of(existingProject));

        // Act & Assert (Actuar y Verificar)
        assertThrows(ProjectAlreadyExistsException.class, () -> service.execute(command));

        // Verificamos que NUNCA se llamó al método save
        verify(saveProjectPort, never()).save(any(ProjectModel.class));
    }

    @Test
    void shouldSaveProjectSuccessfully() {
        // Arrange
        CreateProjectCommand command = new CreateProjectCommand(
                "PRJ-002", "SIRIUS", LocalDate.now(), LocalDate.now().plusDays(5), "PROM-1"
        );
        
        // Simulamos que NO existe en la base de datos
        when(getProjectByIdPort.getById(any(ProjectId.class))).thenReturn(Optional.empty());

        // Act
        ProjectModel result = service.execute(command);

        // Assert
        assertNotNull(result);
        assertEquals("SIRIUS", result.name().value());
        assertEquals(ProjectStatus.PLANNED, result.status());
        
        // Verificamos que SÍ se llamó a guardar exactamente 1 vez
        verify(saveProjectPort, times(1)).save(any(ProjectModel.class));
    }
}