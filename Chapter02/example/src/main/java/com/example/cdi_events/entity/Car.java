package com.example.cdi_events.entity;

public class Car {

    private Specification specification;

    private Car() {
    }

    public Car(Specification specification) {
        this.specification = specification;
    }

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

}
