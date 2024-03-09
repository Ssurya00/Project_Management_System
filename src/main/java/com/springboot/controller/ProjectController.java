package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.ProjectManagement;
import com.springboot.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	public ProjectController(ProjectService projectService) {
		super();
		this.projectService = projectService;
	}
	
	//Save Project API
	@PostMapping()
	public ResponseEntity<ProjectManagement> saveProject(@RequestBody ProjectManagement projectManagement){
		return new ResponseEntity<ProjectManagement>(projectService.saveProject(projectManagement),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public List<ProjectManagement> getAllProjects(){
		return projectService.getAllProjects();
	}
	
	
	//localhost:5051/api/project/1
	@GetMapping("{id}")
	public ResponseEntity<ProjectManagement> getProjectById(@PathVariable("id")long projectId){
		return new ResponseEntity<ProjectManagement>(projectService.getProjectById(projectId), HttpStatus.OK);
	}
	//localhost:5051/api/project/1
	@PutMapping("{id}")
	public ResponseEntity<ProjectManagement> updateProject(@PathVariable("id") long id,
			                                                @RequestBody ProjectManagement projectManagement){
		return new ResponseEntity<ProjectManagement>(projectService.updateProject(projectManagement, id),HttpStatus.OK);
	}
	
	
	//localhost:5051/api/project/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteProject(@PathVariable("id") long id){
		projectService.deleteProjectById(id);
		return new ResponseEntity<String>("Project Deleted successfully",HttpStatus.OK);
	}
	
}
