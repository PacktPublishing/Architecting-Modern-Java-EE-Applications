package com.sebastian_daschner.sample;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.PushBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("http-push")
public class ServletExample {

    @GET
    public String get(@Context HttpServletRequest request) {
        PushBuilder pushBuilder = request.newPushBuilder();
        pushBuilder
                .path("image.png")
                .addHeader(HttpHeaders.CONTENT_TYPE, "image/png")
                .push();


    }


}
