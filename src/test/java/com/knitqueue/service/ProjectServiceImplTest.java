package com.knitqueue.service;

import com.knitqueue.entity.Project;
import com.knitqueue.repository.ProjectRepository;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjectServiceImplTest {

    @Test
    void updateChangesOnlyProvidedFields() {
        // Arrange: Real Project, real service, mock Repo
        ProjectRepository repo = mock(ProjectRepository.class);
        ProjectService service = new ProjectServiceImpl(repo);
        Project project1 = new Project(
                null,
                "Cashmere beanie hat",
                "Inspired by ARKET",
                null,
                null,
                "IDEA");

        when(repo.findById(1)).thenReturn(Optional.of(project1));
        when(repo.save(project1)).thenReturn(project1);

        // Act: Change only a field (projectState)
        Map<String, String> changes = new HashMap<>();
        changes.put("projectState","WIP");
        Project result = service.update(1,changes);

        // Assert: Verify that only the provided field changed
        assertEquals("WIP",result.getProjectState());
        assertEquals("Inspired by ARKET",result.getNotes());
        assertEquals("Cashmere beanie hat",result.getProjectName());
        verify(repo).save(project1);
    }

    @Test
    void updateRejectsInvalidFields() {
        // Arrange
        ProjectRepository repo = mock(ProjectRepository.class);
        ProjectService service = new ProjectServiceImpl(repo);
        Project project1 = new Project(
                null,
                "Cashmere beanie hat",
                "Inspired by ARKET",
                null,
                null,
                "IDEA");

        when(repo.findById(1)).thenReturn(Optional.of(project1));

        // Act
        Map<String, String> changes = new HashMap<>();
        changes.put("appUser","John");

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> service.update(1, changes));
        verify(repo, never()).save(any(Project.class));
    }
}