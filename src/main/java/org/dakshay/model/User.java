package org.dakshay.model;

import java.util.UUID;

public class User {

    private final String id;
    private final String name;
    private final String email;
    private final Long phoneNo;

    public User(String email, String name, Long phoneNo) {
        this.email = email;
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPhoneNo() {
        return phoneNo;
    }
}
