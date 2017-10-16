package com.example.cars.boundary;

import com.example.cars.control.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarManufacturerTest {

    @InjectMocks
    private CarManufacturer testObject;

    @Mock
    private CarFactory carFactory;

    @Mock
    private EntityManager entityManager;

    @Test
    public void test() {
        Specification spec = new Specification();
        Car car = new Car(spec);

        when(entityManager.merge(any())).then(a -> a.getArgument(0));
        when(carFactory.createCar(any())).thenReturn(car);

        assertThat(testObject.manufactureCar(spec)).isEqualTo(car);

        verify(carFactory).createCar(spec);
        verify(entityManager).merge(car);
    }

}
