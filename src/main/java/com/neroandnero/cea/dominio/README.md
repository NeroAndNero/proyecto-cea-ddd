# Proyecto CEA - Capa de Dominio (DDD)

Este repositorio contiene la implementación de la Capa de Dominio para el sistema de gestión de proyectos (CEA), aplicando los principios de Domain-Driven Design (DDD) y Arquitectura Hexagonal.

## Tecnologías
* Java 17
* Maven
* JUnit 5
* Mockito

## Estructura
* **Value Objects**: ProjectId, ProjectName, ProjectDateRange.
* **Agregados**: ProjectModel (Raíz de Agregado).
* **Servicios de Dominio**: CreateProjectService.
* **Puertos**: GetProjectByIdPort, SaveProjectPort.

## Pruebas
Para ejecutar las pruebas unitarias, usa el comando:
```bash
mvn test
