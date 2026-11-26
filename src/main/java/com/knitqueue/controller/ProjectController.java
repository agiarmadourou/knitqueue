package com.knitqueue.controller;

import com.knitqueue.dto.ProjectResponse;
import com.knitqueue.entity.Project;
import com.knitqueue.service.ProjectService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/projects")
    public Project addProject(@RequestBody Project project) {
        Project theProject = projectService.save(project);
        return theProject;
    }

    @GetMapping("/projects/{projectId}")
    public ProjectResponse getProject(@PathVariable int projectId) {
        Project theProject = projectService.findById(projectId);

        return new ProjectResponse(
            theProject.getProjectId(),
            theProject.getProjectName(),
            theProject.getNotes(),
            theProject.getReferenceUrl(),
            theProject.getImageUrl(),
            theProject.getProjectState()
        );
    }
}
