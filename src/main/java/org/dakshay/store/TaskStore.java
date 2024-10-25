package org.dakshay.store;

import org.dakshay.enumeration.TaskStatus;
import org.dakshay.model.Task;
import org.dakshay.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskStore {

    public static TaskStore instance;
    public Map<String, Task> taskData = new ConcurrentHashMap<>(); // Indexed on Task id
    public Map<TaskStatus, Task> taskStatusData = new ConcurrentHashMap<>(); // Indexed on TaskStatus

    private TaskStore(){}

    public static TaskStore getInstance(){
        if(instance==null) {
            instance = new TaskStore();
        }
        return instance;
    }

    public void insert(Task task) {
        taskData.put(task.getId(), task);
        taskStatusData.put(task.getStatus(), task);
    }

    public void update(Task task) {
        String id = task.getId();
        taskData.put(task.getId(), task);
        taskStatusData.put(task.getStatus(), task);
    }

    public Task getTaskByTaskId(String taskId) {
        return taskData.get(taskId);
    }

    public Task getTaskByTaskStatus(TaskStatus taskStatus) {
        return taskStatusData.get(taskStatus);
    }
}
