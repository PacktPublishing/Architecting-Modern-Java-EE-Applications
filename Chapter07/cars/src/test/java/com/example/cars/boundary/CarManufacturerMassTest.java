package com.example.cars.boundary;

import com.example.cars.control.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.Color;
import com.example.cars.entity.EngineType;
import com.example.cars.entity.Specification;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CarManufacturerMassTest {

    private CarManufacturer testObject;

    @Parameterized.Parameter(0)
    public Color chassisColor;

    @Parameterized.Parameter(1)
    public EngineType engineType;

    @Before
    public void setUp() {
        testObject = new CarManufacturer();
        testObject.carFactory = mock(CarFactory.class);
        testObject.entityManager = mock(EntityManager.class);
    }

    @Test
    public void test() {
        // ...
        Specification spec = new Specification();
        spec.setColor(chassisColor);
        spec.setEngine(engineType);
        Car car = new Car(spec);

        when(testObject.entityManager.merge(any())).then(a -> a.getArgument(0));
        when(testObject.carFactory.createCar(any())).thenReturn(car);

        assertThat(testObject.manufactureCar(spec)).isEqualTo(car);

        // ...
        assertThat(car.getSpecification().getEngine()).isEqualTo(engineType);
        assertThat(car.getSpecification().getColor()).isEqualTo(chassisColor);

        verify(testObject.carFactory).createCar(spec);
        verify(testObject.entityManager).merge(car);
    }

    @Parameterized.Parameters(name = "chassis: {0}, engine type: {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(
                new Object[]{Color.RED, EngineType.DIESEL},
                new Object[]{Color.BLACK, EngineType.DIESEL}
        );
    }

}
