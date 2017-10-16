package com.example.core_components.control;


import com.example.core_components.entity.Car;
import com.example.core_components.entity.Specification;

public class CarFactory {

    public Car createCar(Specification spec) {
        // ...
        return new Car(spec);
    }

}
