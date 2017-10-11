package boundary;

import control.CarFactory;
import entity.Car;
import entity.CarCreated;
import entity.Specification;
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

    Tracer tracer;

    public Car manufactureCar(Specification spec) {
        try (ActiveSpan activeSpan = tracer.buildSpan("createCar")
                .withTag("color", spec.getColor().toString())
                .withTag("engine", spec.getEngine().toString())
                .startActive()) {
            Car car = carFactory.createCar(spec);
            entityManager.merge(car);
            carCreated.fire(new CarCreated(spec));
            return car;
        }
    }

}
