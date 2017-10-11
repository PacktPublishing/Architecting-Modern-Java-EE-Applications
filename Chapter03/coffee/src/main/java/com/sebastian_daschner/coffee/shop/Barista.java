package com.sebastian_daschner.coffee.shop;

import com.sebastian_daschner.coffee.Coffee;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Barista {

    @Inject
    BaristaCoffeeShop coffeeShop;

    Coffee makeCoffee() {
        // check temperature & humidity
        // calculate amount of beans & machine settings
        // ...
    }

}
