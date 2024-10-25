package org.dakshay.model;

public class FilterResponse {

    private final Task task;
    private final User user;

    public FilterResponse(Task task, User user) {
        this.task = task;
        this.user = user;
    }

    @Override
    public String toString() {
        return "FilterResponse{" +
                "task=" + task +
                ", user=" + user +
                '}';
    }
}
