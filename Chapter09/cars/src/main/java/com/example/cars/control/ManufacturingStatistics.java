package com.example.cars.control;

import com.example.cars.entity.Specification;
import io.prometheus.client.Counter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;

@ApplicationScoped
public class ManufacturingStatistics {

    private Counter createdCars;

    @PostConstruct
    private void initMetrics() {
        createdCars = Counter.build("cars_manufactured_total",
                "Total number of manufactured cars")
                .labelNames("color", "engine")
                .register();
    }

    public void carCreated(@Observes(during = TransactionPhase.AFTER_SUCCESS) Specification spec) {
        createdCars.labels(spec.getColor().name(), spec.getEngine().name()).inc();
    }

}
