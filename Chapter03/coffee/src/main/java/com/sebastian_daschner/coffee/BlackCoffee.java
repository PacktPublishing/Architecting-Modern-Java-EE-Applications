package com.sebastian_daschner.coffee;

public class BlackCoffee implements Coffee {

    @Override
    public double getCaffeine() {
        return 100.0;
    }

    @Override
    public double getCalories() {
        return 0;
    }
}
