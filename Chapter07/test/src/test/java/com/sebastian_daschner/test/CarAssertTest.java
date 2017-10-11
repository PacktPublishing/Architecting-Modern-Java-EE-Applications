package com.sebastian_daschner.test;

import com.sebastian_daschner.test.entity.Car;
import com.sebastian_daschner.test.entity.EngineType;
import com.sebastian_daschner.test.entity.Specification;
import org.junit.Test;

import java.awt.*;

import static com.sebastian_daschner.test.CarAssert.assertThat;

public class CarAssertTest {

    @Test
    public void test() {
        Specification specification = new Specification();
        specification.setEngine(EngineType.ELECTRIC);
        specification.setColor(Color.BLACK);
        Car car = new Car(specification);

        assertThat(car)
                .hasColor(Color.BLACK)
                .isEnvironmentalFriendly()
                .satisfies(specification);
    }


}
