package com.example.core_components.boundary;

import com.example.core_components.control.CarFactory;
import com.example.core_components.control.CarStorage;
import com.example.core_components.entity.Car;
import com.example.core_components.entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarStorage carStorage;

    public Car manufactureCar(Specification spec) {
        Car car = carFactory.createCar(spec);
        carStorage.store(car);
        return car;
    }

}
