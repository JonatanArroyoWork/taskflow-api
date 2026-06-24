package com.jam.taskflow.api.mappers;

import com.jam.taskflow.api.dto.CreateTaskRequest;
import com.jam.taskflow.api.dto.TaskResponse;
import com.jam.taskflow.domain.model.Task;

public class TaskMapper {

    public Task mapCreateTaskResquestToTask (CreateTaskRequest createTaskRequest) {

        Task task = new Task();
        task.setPriority(createTaskRequest.getPriority());
        task.setDescription(createTaskRequest.getDescription());
        task.setTitle(createTaskRequest.getTitle());
        task.setDueDate(createTaskRequest.getDueDate());
        task.setStatus(createTaskRequest.getStatus());

        return task;
    }

    public TaskResponse mapTaskToTaskResponse (Task task) {

        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setPriority(task.getPriority());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setCreatedAt(task.getCreatedAt());
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setUpdatedAt(task.getUpdatedAt());

        return taskResponse;
    }
}
