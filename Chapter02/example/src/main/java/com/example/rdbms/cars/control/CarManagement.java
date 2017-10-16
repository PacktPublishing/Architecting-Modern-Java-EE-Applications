package com.example.rdbms.cars.control;

import com.example.rdbms.cars.entity.Car;
import com.example.rdbms.cars.entity.Engine;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CarManagement {

    @PersistenceContext
    EntityManager entityManager;

    public void replaceEngine(long carIdentifier, Engine engine) {
        Car car = entityManager.find(Car.class, carIdentifier);
        car.replaceEngine(engine);
        // merge operation is applied on the car and all cascading relations
        entityManager.merge(car);
    }

}
