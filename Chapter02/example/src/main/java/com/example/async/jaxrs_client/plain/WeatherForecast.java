package com.example.async.jaxrs_client.plain;

import com.example.async.jaxrs_client.Forecast;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@ApplicationScoped
public class WeatherForecast {

    private Client client;
    private List<WebTarget> targets;

    @Resource
    ManagedExecutorService mes;

    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newClient();
        targets = asList(
                client.target("..."),
                client.target("...")
        );
    }

    public Forecast getAverageForecast() {
        return invokeTargetsAsync()
                .stream()
                .map(CompletableFuture::join)
                .reduce(this::calculateAverage)
                .orElseThrow(() -> new IllegalStateException("No weather service available"));
    }

    private List<CompletableFuture<Forecast>> invokeTargetsAsync() {
        return targets.stream()
                .map(t -> CompletableFuture.supplyAsync(() -> t
                        .request(MediaType.APPLICATION_JSON_TYPE)
                        .get(Forecast.class), mes))
                .collect(Collectors.toList());
    }

    private Forecast calculateAverage(Forecast first, Forecast second) {
        // ...
        return first;
    }

    @PreDestroy
    public void closeClient() {
        client.close();
    }

}
