package com.sebastian_daschner.sample;

import com.airhacks.porcupine.execution.boundary.Dedicated;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;

@Path("bp")
public class BackPressureResource {

    @Inject
    @Dedicated("custom-name")
    ExecutorService mes;

    @GET
    public CompletionStage<String> getString() {
        return CompletableFuture.supplyAsync(() -> "Hello World", mes);
    }

}
