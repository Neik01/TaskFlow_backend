package com.ntk.TaskFlow.Service;

import com.ntk.TaskFlow.Entity.Project;
import com.ntk.TaskFlow.Repository.ProjectRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository repository;

    public List<Project> getAll(){
        return this.repository.findAll();
    }

    public Optional<Project> getById(int id){
        return this.repository.findById(id);
    }

    public Project create(String name){
        Project newProject = new Project();
        newProject.setName(name);
        return this.repository.save(newProject);
    }
}
