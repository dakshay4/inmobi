package org.dakshay;

import org.dakshay.enumeration.TaskStatus;
import org.dakshay.model.Task;
import org.dakshay.model.User;
import org.dakshay.model.FilterRequest;
import org.dakshay.model.FilterResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ExternalTaskClient externalTaskClient = new ExternalTaskClient();
        User user1 = externalTaskClient.createUser("krishna@inmobi.com", "Krishna", 989898989L);
        User user2 = externalTaskClient.createUser("dakshay@inmobi.com", "Dakshay", 7878787878L);

        Task task1 = externalTaskClient.createTask(user1, "Create Jenkins Job",
                "Create a microservice instance", System.currentTimeMillis() + 50000);

        externalTaskClient.assignTask(user2, task1);

        externalTaskClient.updateTask(task1, TaskStatus.IN_PROGRESS);

        FilterResponse filterResponse = externalTaskClient.filter(new FilterRequest(null, TaskStatus.IN_PROGRESS));
        System.out.println("Filter Response for IN_PROGRESS : " + filterResponse);

        FilterResponse filterResponseCompleted = externalTaskClient.filter(new FilterRequest(null, TaskStatus.COMPLETED));
        System.out.println("Filter Response for COMPLETED : " + filterResponse);

        externalTaskClient.updateTask(null, TaskStatus.COMPLETED);

        filterResponseCompleted = externalTaskClient.filter(new FilterRequest(null, TaskStatus.COMPLETED));
        System.out.println("Filter Response for COMPLETED : " + filterResponse);

    }
}