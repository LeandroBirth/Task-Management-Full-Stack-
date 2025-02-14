package com.birth.task_management.controller;
import com.birth.task_management.model.Task;
import com.birth.task_management.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController { // Class name changed to PascalCase

    private final TaskService taskService;

    public TaskController(TaskService taskService) { // Constructor name matches class name
        this.taskService = taskService;
    }

    //  Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    //  Get all tasks (Optional filtering by status)
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String status) {
        List<Task> tasks = (status != null) ? taskService.getTasksByStatus(status) : taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    //  Get a task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    //  Update a task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        try {
            Task updatedTask = taskService.updateTask(id, task);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //  Delete a task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}

