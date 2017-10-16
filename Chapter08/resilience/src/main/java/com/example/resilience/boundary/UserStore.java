package com.example.resilience.boundary;

import javax.ejb.Stateless;
import javax.xml.registry.infomodel.User;
import java.util.Collections;
import java.util.List;

@Stateless
public class UserStore {

    public List<User> getUsers() {
        // ...
        return Collections.emptyList();
    }

}
