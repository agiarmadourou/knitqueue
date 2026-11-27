package com.knitqueue.service;

import com.knitqueue.entity.Project;
import com.knitqueue.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;


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

  // Update only the fields the user is allowed to edit
  @Override
  public Project update(int projectId, Map<String, String> changes) {
    Project theProject = findById(projectId);

    // allowed keys
    Set<String> allowedFields = Set.of(
            "projectName",
            "notes",
            "imageUrl",
            "referenceUrl",
            "projectState"
    );

    if (!allowedFields.containsAll(changes.keySet())) {
        throw new IllegalArgumentException("Invalid field in update request.");
    }

    if (changes.containsKey("projectName")) {
        theProject.setProjectName(changes.get("projectName"));
    }
    if (changes.containsKey("notes")) {
        theProject.setNotes(changes.get("notes"));
    }
    if (changes.containsKey("imageUrl")) {
        theProject.setImageUrl(changes.get("imageUrl"));
    }
    if (changes.containsKey("referenceUrl")) {
        theProject.setReferenceUrl(changes.get("referenceUrl"));
    }
    if (changes.containsKey("projectState")) {
        theProject.setProjectState(changes.get("projectState"));
    }

    return projectRepository.save(theProject);

  }


  @Override
  public void delete(Project project) {
    projectRepository.delete(project);
  }

  @Override
  public Project findById(int id) {
    return projectRepository.findById(id).orElseThrow(
            () -> new RuntimeException("Project with id " + id + " not found.")
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

  @Override
  public Project retrieveUserProject(int projectId, int userId) {
    return projectRepository
            .findByProjectIdAndAppUser_UserId(projectId,userId)
            .orElseThrow(() -> new NoSuchElementException("Project not found."));
  }
}
