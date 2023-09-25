package com.todoms.todoms.service;
import com.todoms.todoms.entity.Task;
import com.todoms.todoms.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("taskService")
public class TaskServiceImplementation implements TaskService{

    @Autowired
    @Qualifier("taskRepository")
    private TaskRepository taskRepository;
    public Task searchTask(String id) {
        Optional<Task> optionalTask = taskRepository.findById(Integer.parseInt(id));
        if (optionalTask.isPresent()) {
            return optionalTask.get();
        }
        return null;
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getCompleted() {
        return taskRepository.findByCompletedTrue();
    }

    @Override
    public List<Task> getUncompleted() {
        return taskRepository.findByCompletedFalse();
    }

    @Override
    public int completeTask(String id) {
        return taskRepository.completeTaskById(Integer.parseInt(id));
    }
}
