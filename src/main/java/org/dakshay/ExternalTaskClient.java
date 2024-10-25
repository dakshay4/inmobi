package org.dakshay;

import org.dakshay.enumeration.TaskStatus;
import org.dakshay.model.Task;
import org.dakshay.model.User;
import org.dakshay.model.UserTaskMapping;
import org.dakshay.model.FilterRequest;
import org.dakshay.model.FilterResponse;
import org.dakshay.store.TaskStore;
import org.dakshay.store.UserStore;
import org.dakshay.store.UserTaskMappingStore;

public class ExternalTaskClient {

    public User createUser(String email, String name, Long phone) {
        UserStore userInstance = UserStore.getInstance();
        User user = new User(email, name, phone);
        userInstance.insert(user);
        return user;
    }

    public void assignTask(User user, Task task) {
        UserTaskMapping userTaskMapping = new UserTaskMapping(task, user);
        UserTaskMappingStore.getInstance().insert(userTaskMapping);
    }

    public Task createTask(User user, String title, String description, Long dueDate) {
        Task task = new Task(user, title, description, dueDate);
        TaskStore taskStore = TaskStore.getInstance();
        taskStore.insert(task);
        return task;
    }

    public void updateTask(Task task, TaskStatus taskStatus) {
        task.setStatus(taskStatus);
        TaskStore.getInstance().insert(task);
    }

    public FilterResponse filter(FilterRequest filterRequest) {
        String taskId = filterRequest.getTaskId();
        TaskStatus taskStatus = filterRequest.getTaskStatus();

        Task task = null;
        if ((taskId!=null)) task =  TaskStore.getInstance().getTaskByTaskId(taskId);
        if ((taskStatus!=null)) task = TaskStore.getInstance().getTaskByTaskStatus(taskStatus);

        UserTaskMapping userTaskMapping = UserTaskMappingStore.getInstance().getMapping(task.getId());


        return new FilterResponse(task, userTaskMapping.getUser());
    }



}
