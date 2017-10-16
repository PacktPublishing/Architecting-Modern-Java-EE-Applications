package com.example.async.executor_service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Stateless
public class Calculator {

    @Resource
    ManagedExecutorService mes;

    public CompletableFuture<Double> calculateRandomPi(int maxDecimalPlaces) {
        return CompletableFuture.supplyAsync(() -> new Random().nextInt(maxDecimalPlaces) + 1, mes)
                .thenApply(this::calculatePi);
    }

    private double calculatePi(long decimalPlaces) {
        // this may run for a long time
        // ...
        return new Random().nextDouble();
    }

}
