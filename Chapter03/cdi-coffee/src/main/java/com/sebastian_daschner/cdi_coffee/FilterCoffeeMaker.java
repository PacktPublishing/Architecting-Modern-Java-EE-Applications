package com.sebastian_daschner.cdi_coffee;

public class FilterCoffeeMaker implements CoffeeMaker {

    @Override
    public void makeCoffee() {
        // brew coffee
        System.out.println("filter coffee made :)");
    }

}
