package com.example.async.cdi_events.entity;

public class CarCreated {

    private final Specification specification;

    public CarCreated(Specification specification) {
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }
}
