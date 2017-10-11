package com.sebastian_daschner.test.boundary;

import com.sebastian_daschner.test.control.CarFactoryComponent;
import com.sebastian_daschner.test.entity.Car;
import com.sebastian_daschner.test.entity.Specification;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Before;
import org.junit.Test;

public class CarManufacturerTestComponent {

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
