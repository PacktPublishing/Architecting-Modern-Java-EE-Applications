package com.example.cars.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

// proper persistence is not part of this example
@Entity
public class Car {

    @Id
    private long id;

    @Transient
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return specification != null ? specification.equals(car.specification) : car.specification == null;
    }

    @Override
    public int hashCode() {
        return specification != null ? specification.hashCode() : 0;
    }

}
