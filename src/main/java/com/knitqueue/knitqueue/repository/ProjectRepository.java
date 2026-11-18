package com.knitqueue.knitqueue.repository;

import com.knitqueue.knitqueue.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
