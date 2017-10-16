package com.example.async.jaxrs_resource.async_response;

import com.example.async.jaxrs_resource.User;
import com.example.async.jaxrs_resource.UserStore;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.TimeUnit;

@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Resource
    ManagedExecutorService mes;

    @Inject
    UserStore userStore;

    @POST
    public void createUserAsync(User user, @Suspended AsyncResponse response) {

        response.setTimeout(5, TimeUnit.SECONDS);
        response.setTimeoutHandler(r ->
                r.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)));

        mes.submit(() -> response.resume(createUser(user)));
    }

    private Response createUser(User user) {
        userStore.create(user);

        return Response.accepted().build();
    }

}
