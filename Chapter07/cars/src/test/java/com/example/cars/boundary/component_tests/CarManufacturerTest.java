package com.example.cars.boundary.component_tests;

import com.example.cars.boundary.CarManufacturerComponent;
import com.example.cars.control.CarFactoryComponent;
import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;

public class CarManufacturerTest {

    private CarManufacturerComponent carManufacture;
    private CarFactoryComponent carFactory;

    @Before
    public void setUp() {
        carFactory = new CarFactoryComponent();
        carManufacture = new CarManufacturerComponent(carFactory);
    }

    @Test
    public void test() {
        Specification spec = new Specification();
        Car expected = new Car(spec);
        AssertionsForClassTypes.assertThat(carManufacture.manufactureCar(spec)).isEqualTo(expected);

        carManufacture.verifyManufacture(expected);
        carFactory.verifyCarCreation(spec);
    }
}
