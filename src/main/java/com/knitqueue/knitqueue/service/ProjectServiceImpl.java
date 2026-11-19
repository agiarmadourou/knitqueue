package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.Project;
import com.knitqueue.knitqueue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository theProjectRepository) {
        projectRepository = theProjectRepository;
    }


    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(Project project) {
        projectRepository.delete(project);
    }

    @Override
    public Project findById(int theId) {
        return projectRepository.findById(theId).orElseThrow(
                () -> new RuntimeException("Project with id " + theId + " not found.")
        );
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    // Retrieve all projects belonging to the user
    @Override
    public List<Project> retrieveUserProjects(int userId) {
        return projectRepository.findByAppUser_UserId(userId);
    }

    // Retrieve the user's projects filtered by state
    @Override
    public List<Project> retrieveUserProjectsByState(int userId, String state) {
        return projectRepository.findByAppUser_UserIdAndProjectState(userId,state);
    }

    // Search the user's projects by partial title (case-insensitive)
    @Override
    public List<Project> searchUserProjects(int userId, String partialName) {
        return projectRepository.
                findByAppUser_UserIdAndProjectNameContainingIgnoreCase(userId,partialName);
    }
}
