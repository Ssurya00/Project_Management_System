package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.model.ProjectManagement;


public interface ProjectRepository extends JpaRepository<ProjectManagement, Long> {

}
