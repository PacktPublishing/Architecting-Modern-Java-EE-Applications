package com.sebastian_daschner.test.boundary;

import com.sebastian_daschner.test.control.CarFactoryComponent;
import com.sebastian_daschner.test.entity.Car;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.verify;

public class CarManufacturerComponent extends CarManufacturer {

    public CarManufacturerComponent(CarFactoryComponent carFactoryComponent) {
        entityManager = Mockito.mock(EntityManager.class);
        carFactory = carFactoryComponent;
    }

    public void verifyManufacture(Car car) {
        verify(entityManager).merge(car);
    }

}
