package com.knitqueue.repository;

import com.knitqueue.entity.Project;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByAppUser_UserId(int userId);
    List<Project> findByAppUser_UserIdAndProjectState(int userId, String projectState);
    List<Project> findByAppUser_UserIdAndProjectNameContainingIgnoreCase(int userId, String partialName);
    Optional<Project> findByProjectIdAndAppUser_UserId(int projectId, int userId);

}
