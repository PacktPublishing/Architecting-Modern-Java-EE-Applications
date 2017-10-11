package com.sebastian_daschner.test.boundary;

import com.sebastian_daschner.test.control.CarFactory;
import com.sebastian_daschner.test.entity.EngineType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.persistence.EntityManager;
import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;

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
//        when(testObject.control.someMethod()).thenReturn(<car>);

//        assertThat(inputParameter).isEqualTo(expected);
        System.out.println("chassisColor = " + chassisColor);
        System.out.println("engineType = " + engineType);
    }

    @Parameterized.Parameters(name = "chassis: {0}, engine type: {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(
                new Object[]{Color.RED, EngineType.DIESEL},
                new Object[]{Color.BLACK, EngineType.DIESEL}
        );
    }
}
