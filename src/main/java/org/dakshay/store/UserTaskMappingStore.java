package org.dakshay.store;

import org.dakshay.model.UserTaskMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserTaskMappingStore {

    private static UserTaskMappingStore instance;
    private Map<String, UserTaskMapping> data = new ConcurrentHashMap<>();

    private UserTaskMappingStore(){}

    public static UserTaskMappingStore getInstance() {
        if(instance == null) {
            instance = new UserTaskMappingStore();
        }
        return instance;
    }

    public void insert(UserTaskMapping userTaskMapping) {
        data.put(userTaskMapping.getTask().getId(), userTaskMapping);
    }

    public UserTaskMapping getMapping(String taskId) {
        return data.get(taskId);
    }
}
