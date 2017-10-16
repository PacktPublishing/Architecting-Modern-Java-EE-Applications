package com.example.cars.boundary;

import com.example.cars.control.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @PersistenceContext
    EntityManager entityManager;

    public Car manufactureCar(Specification spec) {
        Car car = carFactory.createCar(spec);
        entityManager.merge(car);
        return car;
    }

}
