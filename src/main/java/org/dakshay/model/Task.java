package org.dakshay.model;

import org.dakshay.enumeration.TaskStatus;

import java.util.UUID;

public class Task {

    private final String id;
    private final String title;
    private final String description;
    private final Long dueDate; // Epoch in Milliseconds
    private final User createdBy;
    private TaskStatus status;

    public Task(User createdBy, String title, String description, Long dueDate) {
        this.createdBy = createdBy;
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = TaskStatus.PENDING;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public String getDescription() {
        return description;
    }

    public Long getDueDate() {
        return dueDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }
}
