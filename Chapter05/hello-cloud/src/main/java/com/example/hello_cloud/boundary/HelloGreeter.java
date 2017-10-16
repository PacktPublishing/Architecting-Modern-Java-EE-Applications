package com.example.hello_cloud.boundary;

import com.example.hello_cloud.control.Config;

import javax.inject.Inject;
import javax.ws.rs.GET;

public class HelloGreeter {

    @Inject
    @Config("hello.greeting")
    String greeting;

    @Inject
    @Config("hello.name")
    String greetingName;

    @GET
    public String processGreeting() {
        return greeting + ", " + greetingName;
    }

}

