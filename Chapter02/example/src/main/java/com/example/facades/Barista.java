package com.example.facades;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Barista {

    @Inject
    BaristaCoffeeShop coffeeShop;

    Coffee makeCoffee() {
        // check temperature & humidity
        // calculate amount of beans & machine settings
        // fetch & grind beans
        // operate espresso machine

        return null;
    }

}
