package com.example.singletons.container_concurrency;

import com.example.core_components.entity.Car;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class CarStorage {

    private final Map<String, Car> cars = new HashMap<>();

    @Lock
    public void store(Car car) {
        cars.put(car.getId(), car);
    }

    @Lock(LockType.READ)
    public Car retrieve(String id) {
        return cars.get(id);
    }

}
