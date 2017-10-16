package com.example.decorators.cdi;

import javax.inject.Inject;

public class CoffeeConsumer {

    @Inject
    CoffeeMaker coffeeMaker;

    // ...
}
