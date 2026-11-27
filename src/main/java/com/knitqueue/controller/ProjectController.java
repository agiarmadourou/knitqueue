package com.knitqueue.controller;

import com.knitqueue.dto.ProjectResponse;
import com.knitqueue.entity.AppUser;
import com.knitqueue.entity.Project;
import com.knitqueue.service.AppUserService;
import com.knitqueue.service.ProjectService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProjectController {
    private final ProjectService projectService;
    private final AppUserService appUserService;

    public ProjectController(ProjectService projectService, AppUserService appUserService) {
        this.projectService = projectService;
        this.appUserService = appUserService;
    }

//    @PostMapping("/projects")
//    public Project addProject(@RequestBody Project project) {
//        Project theProject = projectService.save(project);
//        return theProject;
//    }

    @GetMapping("/projects/{projectId}")
    public ProjectResponse getProject(@PathVariable int projectId, Authentication authentication) {
        String email = authentication.getName();
        AppUser appUser = appUserService.findByEmail(email);
        Project theProject = projectService.retrieveUserProject(projectId,appUser.getUserId());

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
