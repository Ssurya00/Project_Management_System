package com.springboot.service;

import java.util.List;

import com.springboot.model.ProjectManagement;

public interface ProjectService {
	
	ProjectManagement saveProject(ProjectManagement projectManagement);
	List<ProjectManagement> getAllProjects();
	ProjectManagement getProjectById(long id);
	ProjectManagement updateProject(ProjectManagement projectManagement,long id);
	void deleteProjectById(long id);

}
