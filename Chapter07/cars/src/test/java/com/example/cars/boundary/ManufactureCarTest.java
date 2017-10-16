package com.example.cars.boundary;

import com.example.cars.control.empty.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Component test using plain instantiation.
 */
public class ManufactureCarTest {

    private CarManufacturer carManufacturer;

    @Before
    public void setUp() {
        carManufacturer = new CarManufacturer();
        carManufacturer.carFactory = new CarFactory();
        carManufacturer.entityManager = mock(EntityManager.class);
    }

    @Test
    public void test() {
        when(carManufacturer.entityManager.merge(any())).then(a -> a.getArgument(0));

        Specification spec = new Specification();
        Car expected = new Car(spec);

        assertThat(carManufacturer.manufactureCar(spec)).isEqualTo(expected);
        verify(carManufacturer.entityManager).merge(any(Car.class));
    }

}