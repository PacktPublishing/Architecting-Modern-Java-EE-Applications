package com.sebastian_daschner.test.control;

import com.sebastian_daschner.test.entity.Car;
import com.sebastian_daschner.test.entity.Specification;

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
