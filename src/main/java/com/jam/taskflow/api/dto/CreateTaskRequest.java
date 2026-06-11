package com.jam.taskflow.api.dto;

import com.jam.taskflow.domain.model.TaskPriority;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class CreateTaskRequest {

    @NotBlank
    private String title;

    private String description;

    private TaskPriority priority;

    private LocalDateTime dueDate;

    public CreateTaskRequest() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
