package com.example.jaxrs.boundary;

import com.example.jaxrs.entity.User;

import java.util.List;

import static java.util.Arrays.asList;

public class UserStore {

    public List<User> getUsers() {
        return asList(new User(1L, "duke"));
    }

    public long create(User user) {
        // ...
        return 1L;
    }

    public User getUser(long id) {
        return new User(id, "duke");
    }

    public boolean isNameTaken(String string) {
        // ...
        return false;
    }

}
