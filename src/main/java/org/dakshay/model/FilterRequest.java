package org.dakshay.model;

import org.dakshay.enumeration.TaskStatus;

public class FilterRequest {

    private String taskId;
    private TaskStatus taskStatus;

    public FilterRequest(String taskId, TaskStatus taskStatus) {
        this.taskId = taskId;
        this.taskStatus = taskStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
