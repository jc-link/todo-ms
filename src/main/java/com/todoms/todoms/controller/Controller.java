package com.todoms.todoms.controller;

import com.todoms.todoms.entity.Task;
import com.todoms.todoms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    @Qualifier("taskService")
    private TaskService service;

    @GetMapping("/searchtask")
    public Task searchTask(@RequestParam String id) {
        return service.searchTask(id);
    }

    @GetMapping("/get-tasks")
    public List<Task> getTasks() {
        return service.getTasks();
    }

    @GetMapping("/get-completed")
    public List<Task> getCompleted() {
        return service.getCompleted();
    }

    @GetMapping("/get-uncompleted")
    public List<Task> getUncompleted() {
        return service.getUncompleted();
    }

    @PostMapping(path = "/createtask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean createTask(@RequestBody Task task) {
        service.createTask(task);
        return true;
    }

    @PostMapping("/complete-task")
    public int completeTask(@RequestParam String id) {
        return service.completeTask(id);
    }
}
