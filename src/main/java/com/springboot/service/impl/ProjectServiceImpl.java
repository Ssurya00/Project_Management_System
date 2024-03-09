package com.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.ProjectManagement;
import com.springboot.repository.ProjectRepository;
import com.springboot.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		super();
		this.projectRepository = projectRepository;
	}

	//Save projects
	@Override
	public ProjectManagement saveProject(ProjectManagement projectManagement) {
		return projectRepository.save(projectManagement);
	}

	//Get All Projects
	@Override
	public List<ProjectManagement> getAllProjects() {
		return projectRepository.findAll();
	}

	//GetProjectById
	@Override
	public ProjectManagement getProjectById(long id) {
		return projectRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Project", "id", id) );
	}

	//Update Project
	@Override
	public ProjectManagement updateProject(ProjectManagement projectManagement, long id) {
		ProjectManagement existingProject=projectRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("Project", "id", id));
		existingProject.setName(projectManagement.getName());
		existingProject.setDescription(projectManagement.getDescription());
		existingProject.setStartDate(projectManagement.getStartDate());
		existingProject.setEndDate(projectManagement.getEndDate());
		projectRepository.save(existingProject);
		
		return existingProject;
	}

	//Delete ProjectById
	@Override
	public void deleteProjectById(long id) {
		projectRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Project", "id", id));
		projectRepository.deleteById(id);
		
	}
	
	
}
