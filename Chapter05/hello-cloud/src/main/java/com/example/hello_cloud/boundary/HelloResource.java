package com.example.hello_cloud.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @Inject
    HelloGreeter greeter;

    @GET
    public String hello() {
        return greeter.processGreeting();
    }

}
