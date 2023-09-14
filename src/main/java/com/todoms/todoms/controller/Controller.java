package com.todoms.todoms.controller;

import com.todoms.todoms.model.Task;
import com.todoms.todoms.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    @Qualifier("taskService")
    private TaskService service;

    @GetMapping("/get-by-id")
    public Task getTaskById(@RequestParam String id) {
        return service.searchTask(id);
    }

    @PostMapping(path = "/newtask", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Task newTask(@RequestBody Task task) {
        return task;
    }
}
