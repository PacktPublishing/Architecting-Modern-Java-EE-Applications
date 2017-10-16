package com.example.cars.boundary;

import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@RunWith(CdiRunner.class)
public class ManufactureCarIT {

    @Inject
    CarManufacturer carManufacturer;

    @Mock
    EntityManager entityManager;

    @Before
    public void setUp() {
        carManufacturer.entityManager = entityManager;
    }

    @Test
    public void test() {
        Specification spec = new Specification();
        Car expected = new Car(spec);
        assertThat(carManufacturer.manufactureCar(spec)).isEqualTo(expected);

        verify(entityManager).merge(expected);
    }

}
