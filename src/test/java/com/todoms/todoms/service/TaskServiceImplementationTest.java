package com.todoms.todoms.service;

import com.todoms.todoms.entity.Task;
import com.todoms.todoms.repository.TaskRepository;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplementationTest extends TestCase {

    @InjectMocks
    private TaskServiceImplementation taskServiceImplementation;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void searchTaskShouldReturnATask() {
        int id = 4;
        Task task = new Task();
        task.setId(id);
        task.setName("Task 4");
        task.setDescription("Do Task 4");
        task.setCompleted(false);

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        Task result = taskServiceImplementation.searchTask(String.valueOf(id));
        assertEquals(task, result);
    }

    public void searchTaskShouldReturnNull() {
        int id = 4;
        Task result;
        when(taskRepository.findById(id)).thenReturn(Optional.empty());
        result = taskServiceImplementation.searchTask(String.valueOf(id));
        assertNull(result);
    }

    public void getTasksShouldReturnATaskList() {
        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task();
        task1.setId(1);
        task1.setName("Test Task 1");
        task1.setDescription("This is a test task");
        task1.setCompleted(false);
        tasks.add(task1);

        Task task2 = new Task();
        task2.setId(2);
        task2.setName("Test Task 2");
        task2.setDescription("This is another test task");
        task2.setCompleted(true);
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);
        List<Task> result = taskServiceImplementation.getTasks();
        assertEquals(tasks, result);
    }
}