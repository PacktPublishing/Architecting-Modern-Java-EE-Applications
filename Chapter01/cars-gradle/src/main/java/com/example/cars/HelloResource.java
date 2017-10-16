package com.example.cars;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloResource {

    @GET
    public String hello() {
        return "Hello World";
    }

}
