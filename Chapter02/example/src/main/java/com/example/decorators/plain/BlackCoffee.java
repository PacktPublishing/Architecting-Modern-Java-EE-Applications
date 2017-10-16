package com.example.decorators.plain;

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
