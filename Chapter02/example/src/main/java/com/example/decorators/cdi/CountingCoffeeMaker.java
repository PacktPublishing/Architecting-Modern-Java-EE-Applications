package com.example.decorators.cdi;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class CountingCoffeeMaker implements CoffeeMaker {

    private static final int MAX_COFFEES = 3;
    private int count;

    @Inject
    @Any
    @Delegate
    CoffeeMaker coffeeMaker;

    @Override
    public void makeCoffee() {
        if (count >= MAX_COFFEES)
            throw new IllegalStateException("Reached maximum coffee limit.");
        count++;

        coffeeMaker.makeCoffee();
    }

}
