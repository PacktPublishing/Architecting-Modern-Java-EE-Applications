package com.sebastian_daschner.test.boundary;

import com.sebastian_daschner.test.control.CarFactory;
import com.sebastian_daschner.test.entity.Car;
import com.sebastian_daschner.test.entity.Specification;

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
