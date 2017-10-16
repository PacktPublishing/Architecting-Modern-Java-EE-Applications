package com.example.cars.control;

import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;

public class CarFactory {

    public Car createCar(Specification spec) {
        // ...
        return new Car(spec);
    }
}
