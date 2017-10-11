package com.sebastian_daschner.cdi_coffee;

import org.junit.Before;
import org.junit.Test;

public class FilterCoffeeMakerTest {

    private FilterCoffeeMaker coffeeMaker;

    @Before
    public void setUp() {
        coffeeMaker = new FilterCoffeeMaker();
    }

    @Test
    public void testMakeCoffee() {
        coffeeMaker.makeCoffee();
    }

}