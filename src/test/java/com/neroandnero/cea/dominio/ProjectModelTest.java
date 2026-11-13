package com.neroandnero.cea.dominio;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class ProjectModelTest {

    @Test
    void shouldCreateProjectInPlannedState() {
        // Arrange
        ProjectId id = new ProjectId("PRJ-001");
        ProjectName name = new ProjectName("ORION");
        ProjectDateRange dateRange = new ProjectDateRange(LocalDate.now(), LocalDate.now().plusDays(10));
        
        // Act
        ProjectModel project = ProjectModel.create(id, name, dateRange, "PROMOTOR-1");

        // Assert
        assertEquals(ProjectStatus.PLANNED, project.status());
    }

    @Test
    void shouldChangeStatusToInProgressWhenStarted() {
        ProjectModel project = ProjectModel.create(
            new ProjectId("PRJ-001"), 
            new ProjectName("ORION"), 
            new ProjectDateRange(LocalDate.now(), LocalDate.now().plusDays(10)), 
            "PROMOTOR-1"
        );
        
        ProjectModel startedProject = project.start();
        
        assertEquals(ProjectStatus.IN_PROGRESS, startedProject.status());
    }
}