package com.birth.task_management.repository;

import com.birth.task_management.model.Status;
import com.birth.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(Status status); // Use the Status enum
}