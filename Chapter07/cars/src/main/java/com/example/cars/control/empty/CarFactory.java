package com.example.cars.control.empty;

import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;

public class CarFactory extends com.example.cars.control.CarFactory {

    @Override
    public Car createCar(Specification spec) {
        // example without dependencies, overrides CarFactory to make test example work
        // ...
        return new Car(spec);
    }

}
