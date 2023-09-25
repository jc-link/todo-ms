package com.todoms.todoms.service;

import com.todoms.todoms.entity.Task;

import java.util.List;


public interface TaskService {
    Task searchTask(String id);
    void createTask(Task task);

    List<Task> getTasks();

    List<Task> getCompleted();

    List<Task> getUncompleted();

    int completeTask(String id);
}
