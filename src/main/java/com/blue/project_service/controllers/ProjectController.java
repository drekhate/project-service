package com.blue.project_service.controllers;

import com.blue.project_service.dtos.CreateProjectRequest;
import com.blue.project_service.models.Project;
import com.blue.project_service.services.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {
    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping(value = "/createProject")
    public ResponseEntity<String> createProject(@RequestBody CreateProjectRequest createProjectRequest) {
        String result = projectService.createProject(createProjectRequest);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @GetMapping(value = "/getProjectById/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable("projectId") Integer projectId) {
        Project result = projectService.getProjectById(projectId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @PatchMapping("/updateProjectById/{projectId}")
    public ResponseEntity<String> updateProjectById(@PathVariable("projectId") Integer projectId, @RequestBody Project projectUpdate) {
        String result = projectService.updateProjectById(projectId, projectUpdate);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @DeleteMapping("/deleteProjectById/{projectId}")
    public ResponseEntity<String> deleteProjectById(@PathVariable("projectId") Integer projectId) {
        String result = projectService.deleteProjectById(projectId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
