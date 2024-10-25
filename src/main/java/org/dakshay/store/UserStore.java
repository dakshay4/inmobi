package org.dakshay.store;

import org.dakshay.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStore {

    public static UserStore instance;
    public Map<String, User> userData = new HashMap<>();

    private UserStore(){}

    public static UserStore getInstance(){
        if(instance==null) {
            instance = new UserStore();
        }
        return instance;
    }

    public void insert(User user) {
        userData.put(user.getId(), user);
    }

}
