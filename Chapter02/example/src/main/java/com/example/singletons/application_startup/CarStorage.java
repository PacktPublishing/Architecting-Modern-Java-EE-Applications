package com.example.singletons.application_startup;

import com.example.core_components.entity.Car;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class CarStorage {

    private final Map<String, Car> cars = new ConcurrentHashMap<>();

    @PostConstruct
    private void loadStorage() {
        // load contents from file
    }

    public void store(Car car) {
        cars.put(car.getId(), car);
    }

    public Car retrieve(String id) {
        return cars.get(id);
    }

    @PreDestroy
    public void writeStorage() {
        // write contents to file
    }

}
