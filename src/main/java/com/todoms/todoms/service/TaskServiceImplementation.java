package com.todoms.todoms.service;

import com.todoms.todoms.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("taskService")
public class TaskServiceImplementation implements TaskService{
    public Task searchTask(String id) {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Do this task"));
        tasks.add(new Task("Task 2", "Do this task"));
        tasks.add(new Task("Task 3", "Do this task"));
        tasks.add(new Task("Task 4", "Do this task"));
        for (Task task: tasks) {
            if(task.getName().equals(id)) {
                return task;
            }
        }
        return null;
    }
}
