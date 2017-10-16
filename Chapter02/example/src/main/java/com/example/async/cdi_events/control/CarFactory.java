package com.example.async.cdi_events.control;

import com.example.async.cdi_events.entity.Car;
import com.example.async.cdi_events.entity.Specification;

public class CarFactory {

    public Car createCar(Specification spec) {
        // ...
        return new Car();
    }

}
