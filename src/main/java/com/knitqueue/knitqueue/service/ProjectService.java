package com.knitqueue.knitqueue.service;

import com.knitqueue.knitqueue.entity.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);
    void delete(Project project);
    Project findById(int id);
    List<Project> findAll();
    List<Project>  retrieveUserProjects(int userId);
    List<Project>  retrieveUserProjectsByState(int userId,String state);
    List<Project>  searchUserProjects(int userId,String partialName);
}
