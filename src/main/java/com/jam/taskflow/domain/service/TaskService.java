package com.jam.taskflow.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jam.taskflow.api.dto.CreateTaskRequest;
import com.jam.taskflow.api.dto.UpdateTaskRequest;
import com.jam.taskflow.api.dto.TaskResponse;
import com.jam.taskflow.api.mappers.TaskMapper;
import com.jam.taskflow.domain.model.Task;
import com.jam.taskflow.domain.model.TaskStatus;
import com.jam.taskflow.persistence.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskResponse> getAllTasks() {
        return taskRepository.findAll().stream()
                             .map(taskMapper::mapTaskToTaskResponse)
                             .collect(Collectors.toList());
    }

    public TaskResponse getTaskById(UUID id) {
        Task task = taskRepository.findById(id)
                                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada"));
        return taskMapper.mapTaskToTaskResponse(task);
    }

    @Transactional
    public TaskResponse createTask(CreateTaskRequest request) {
        Task task = taskMapper.mapCreateTaskResquestToTask(request);
        task.setStatus(TaskStatus.PENDING);
        Task savedTask = taskRepository.save(task);
        return taskMapper.mapTaskToTaskResponse(savedTask);
    }

    @Transactional
    public TaskResponse updateTask(UUID id, UpdateTaskRequest request) {
        Task task = taskRepository.findById(id)
                                  .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada"));

        if (request.getTitle() != null) task.setTitle(request.getTitle());
        if (request.getDescription() != null) task.setDescription(request.getDescription());
        if (request.getPriority() != null) task.setPriority(request.getPriority());
        if (request.getDueDate() != null) task.setDueDate(request.getDueDate());
        if (request.getStatus() != null) task.setStatus(request.getStatus());

        Task updatedTask = taskRepository.save(task);
        return taskMapper.mapTaskToTaskResponse(updatedTask);
    }

    @Transactional
    public void deleteTask(UUID id) {
        if (!taskRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        taskRepository.deleteById(id);
    }
}
