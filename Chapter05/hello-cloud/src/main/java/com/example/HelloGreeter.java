package com.sebastian_daschner.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greet")
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

