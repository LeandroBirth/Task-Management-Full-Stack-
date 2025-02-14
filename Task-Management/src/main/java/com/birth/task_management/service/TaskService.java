package com.birth.task_management.service;
import com.birth.task_management.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
        Task createTask(Task task);
        Optional<Task> getTaskById(Long id);
        List<Task> getAllTasks();
        List<Task> getTasksByStatus(String status);
        Task updateTask(Long id, Task task);
        void deleteTask(Long id);
    }
