package com.example.resilience.boundary;

import com.airhacks.porcupine.execution.boundary.Dedicated;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.registry.infomodel.User;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

@Path("users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    @Dedicated("custom-name")
    ExecutorService executorService;

    @Inject
    UserStore userStore;

    @GET
    public CompletionStage<Response> get() {
        return CompletableFuture.supplyAsync(this::getUsers, executorService)
                .thenApply(s -> Response.ok(s).build());
    }

    private List<User> getUsers() {
        // ...
        return userStore.getUsers();
    }

}
