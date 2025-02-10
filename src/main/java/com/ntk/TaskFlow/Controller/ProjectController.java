package com.ntk.TaskFlow.Controller;


import com.ntk.TaskFlow.DTO.Entities.ProjectDTO;
import com.ntk.TaskFlow.Entity.Project;
import com.ntk.TaskFlow.Entity.Task;
import com.ntk.TaskFlow.Mapper.ProjectMapper;
import com.ntk.TaskFlow.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/projects")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    private final ProjectMapper mapper;

    @GetMapping
    public List<ProjectDTO> getAll(){
        return this.mapper.mapListProjectToListDTO(this.projectService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDTO> getById(@PathVariable int id){
        Optional<Project> project = this.projectService.getById(id);
        return project.map(project1 -> new ResponseEntity<>(mapper.mapProjectToDTO(project1), HttpStatus.FOUND))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProjectDTO create(@RequestBody String name){
        return mapper.mapProjectToDTO(projectService.create(name));
    }
}
