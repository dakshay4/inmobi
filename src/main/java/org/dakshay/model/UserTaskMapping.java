package org.dakshay.model;

public class UserTaskMapping {
    private final Task task;
    private final User user;


    public UserTaskMapping(Task task, User user) {
        this.task = task;
        this.user = user;
    }

    public Task getTask() {
        return task;
    }

    public User getUser() {
        return user;
    }
}
