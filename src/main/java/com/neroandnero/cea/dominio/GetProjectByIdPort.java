package com.neroandnero.cea.dominio;

import java.util.Optional;

public interface GetProjectByIdPort {
    Optional<ProjectModel> getById(ProjectId id);
}