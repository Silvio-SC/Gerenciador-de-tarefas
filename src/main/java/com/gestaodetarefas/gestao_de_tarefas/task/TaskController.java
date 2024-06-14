package com.gestaodetarefas.gestao_de_tarefas.task;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

@RestController
@RequestMapping("/api/tasks")

public class TaskController {
    private ArrayList<TaskEntity> taskList = new ArrayList<>();


    @GetMapping
    public ArrayList<TaskEntity> read(){
        return taskList;
    };

    @GetMapping("/{taskId}")
    public Optional<TaskEntity> retrive(@PathVariable int taskId){

        return taskList.stream().filter(t -> t.getId() == taskId).findFirst();
                
    }

    @PostMapping
    public TaskEntity createTask(@RequestBody TaskEntity payload){
        // UUID id = new UUIDGenerator();

        int size = 1;
        int id = size;
        if (taskList.size() > 0) {
            size = taskList.size() - 1;
            id = taskList.get(size).getId() + 1; 
        }


        TaskEntity newTask = new TaskEntity(id, payload.getTitle(), payload.getStatus(), payload.getDescription());

        taskList.add(newTask);

        return newTask;
    }

    @PutMapping("/{taskId}")
    public Optional<TaskEntity> updateTask(@PathVariable int taskId, @RequestBody TaskEntity payload){
        var updatedTasks = taskList.stream().map(t -> {
            if(t.getId() == taskId){
                t.setTitle(payload.getTitle());
                t.setStatus(payload.getStatus());
                t.setDescription(payload.getDescription());
                return t;
            } else {
                return t;
            }
        });

        taskList = new ArrayList<>(updatedTasks.toList());
        
        return taskList.stream().filter(t -> t.getId() == taskId).findFirst();
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable int taskId){
       var updatedTasks = taskList.stream().filter(t -> !(t.getId() == taskId));
       taskList = new ArrayList<>(updatedTasks.toList());

    }


}
