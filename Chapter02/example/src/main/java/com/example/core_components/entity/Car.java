package com.example.core_components.entity;

public class Car {

    private String id;
    private Specification specification;

    private Car() {
    }

    public Car(Specification specification) {
        this.specification = specification;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

        if (id != null ? !id.equals(car.id) : car.id != null) return false;
        return specification != null ? specification.equals(car.specification) : car.specification == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (specification != null ? specification.hashCode() : 0);
        return result;
    }
}
