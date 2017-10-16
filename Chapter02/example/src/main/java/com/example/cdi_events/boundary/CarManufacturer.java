package com.example.cdi_events.boundary;

import com.example.cdi_events.control.CarFactory;
import com.example.cdi_events.entity.Car;
import com.example.cdi_events.entity.CarCreated;
import com.example.cdi_events.entity.Specification;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    Event<CarCreated> carCreated;

    public Car manufactureCar(Specification spec) {
        Car car = carFactory.createCar(spec);
        carCreated.fire(new CarCreated(spec));
        return car;
    }

}
