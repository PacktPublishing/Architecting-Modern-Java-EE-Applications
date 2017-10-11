package com.sebastian_daschner.cdi_coffee;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class CoffeeConsumer {

    @Inject
    CoffeeMaker coffeeMaker;

    @Schedule(second = "*/3", minute = "*", hour = "*")
    public void fire() {
        coffeeMaker.makeCoffee();
    }
    // ..
}
