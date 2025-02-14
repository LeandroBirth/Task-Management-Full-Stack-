package com.birth.task_management.service;

import com.birth.task_management.model.Status;
import com.birth.task_management.model.Task;
import com.birth.task_management.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        // Save the task to the database
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        // Retrieve the task by ID
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        // Retrieve all tasks
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        try {
            // Convert the String status to the Status enum
            Status taskStatus = Status.valueOf(status.toUpperCase());
            // Retrieve tasks by status
            return taskRepository.findByStatus(taskStatus);
        } catch (IllegalArgumentException e) {
            // Handle invalid status values
            throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    @Override
    public Task updateTask(Long id, Task task) {
        // Check if the task exists
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            // Update the task fields
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setStatus(task.getStatus());
            // Save the updated task
            return taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found with id: " + id);
        }
    }

    @Override
    public void deleteTask(Long id) {
        // Delete the task by ID
        taskRepository.deleteById(id);
    }
}