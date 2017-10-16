package com.example.cars.boundary;

import com.example.cars.control.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.CarCreated;
import com.example.cars.entity.Specification;
import io.opentracing.ActiveSpan;
import io.opentracing.Tracer;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    Event<CarCreated> carCreated;

    @PersistenceContext
    EntityManager entityManager;

    @Inject
    Tracer tracer;

    public Car manufactureCar(Specification spec) {
        try (ActiveSpan span = tracer.buildSpan("createCar")
                .withTag("color", spec.getColor().toString())
                .withTag("engine", spec.getEngine().toString())
                .startActive()) {

            Car car = carFactory.createCar(spec);
            entityManager.merge(car);
            carCreated.fire(new CarCreated(spec));

            span.log("Car successfully created");

            return car;
        }
    }

}
