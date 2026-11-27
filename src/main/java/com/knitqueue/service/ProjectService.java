package com.knitqueue.service;

import com.knitqueue.entity.Project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    Project save(Project project);

    // Update only the fields the user is allowed to edit
    Project update(int projectId, Map<String, String> changes);


    void delete(Project project);

    Project findById(int id);

    List<Project> findAll();

    List<Project>  retrieveUserProjects(int userId);

    List<Project>  retrieveUserProjectsByState(int userId,String state);

    List<Project>  searchUserProjects(int userId,String partialName);

    Project retrieveUserProject(int projectId, int userId);
}
