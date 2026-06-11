package com.jam.taskflow.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jam.taskflow.domain.model.Task;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}

