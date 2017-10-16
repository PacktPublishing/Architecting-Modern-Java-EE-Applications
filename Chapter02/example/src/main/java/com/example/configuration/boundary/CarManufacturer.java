package com.example.configuration.boundary;

import com.example.configuration.control.Config;
import com.example.configuration.entity.Car;
import com.example.configuration.entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    @Config("car.default.color")
    String defaultColor;

    public Car manufactureCar(Specification spec) {
        // use defaultColor

        // ...
        return new Car();
    }

}
