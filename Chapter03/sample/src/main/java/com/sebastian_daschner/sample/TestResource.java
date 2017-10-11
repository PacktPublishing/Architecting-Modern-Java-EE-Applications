package com.sebastian_daschner.sample;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("test")
public class TestResource {

    @Inject
    Greeter greeter;

    @GET
    @Path("{name}")
    public String test(@PathParam("name") String name) {
        return greeter.greet(name);
    }

}
