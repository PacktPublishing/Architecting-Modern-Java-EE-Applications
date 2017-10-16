package com.example.cdi_producers;

import javax.enterprise.inject.Produces;

public class CarFactoryProducer {

    @Produces
    public CarFactory exposeCarFactory() {
        CarFactory factory = new CarFactory();
        // use custom logic
        return factory;
    }

}
