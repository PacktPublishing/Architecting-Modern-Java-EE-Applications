package com.example.cars;

import com.example.cars.entity.Car;
import com.example.cars.entity.Color;
import com.example.cars.entity.EngineType;
import com.example.cars.entity.Specification;
import org.assertj.core.api.AbstractAssert;

import java.util.Objects;

public class CarAssert extends AbstractAssert<CarAssert, Car> {

    public CarAssert(Car actual) {
        super(actual, CarAssert.class);
    }

    public static CarAssert assertThat(Car actual) {
        return new CarAssert(actual);
    }

    public CarAssert hasEngine(EngineType type) {
        isNotNull();

        if (!Objects.equals(actual.getSpecification().getEngine(), type)) {
            failWithMessage("Expected car's engine to be <%s> but was <%s>", type, actual.getSpecification().getEngine());
        }
        return this;
    }

    public CarAssert satisfies(Specification spec) {
        isNotNull();

        if (!Objects.equals(actual.getSpecification(), spec)) {
            failWithMessage("Expected car to match <%s> but was <%s>", spec, actual.getSpecification());
        }
        return this;
    }

    public CarAssert hasColor(Color color) {
        isNotNull();

        if (!Objects.equals(actual.getSpecification().getColor(), color)) {
            failWithMessage("Expected car's color to be <%s> but was <%s>", color, actual.getSpecification().getColor());
        }
        return this;
    }

    public CarAssert isEnvironmentalFriendly() {
        isNotNull();

        if (actual.getSpecification().getEngine() != EngineType.ELECTRIC) {
            failWithMessage("Expected car with environmental friendly engine but was <%s>", actual.getSpecification().getEngine());
        }
        return this;
    }

}