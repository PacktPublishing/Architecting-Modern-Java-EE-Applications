package com.example.cars.control;

import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;

import javax.inject.Inject;

public class CarFactory {

    @Inject
    Automation automation;

    @Inject
    AssemblyLine assemblyLine;

    public Car createCar(Specification spec) {
        assemblyLine.assemble(spec);
        automation.isAutomated();

        return new Car(spec);
    }

}
