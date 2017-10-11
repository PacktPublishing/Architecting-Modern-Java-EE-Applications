package com.sebastian_daschner.car_enthusiast;

import javax.enterprise.inject.Produces;

public class BMWCarManufacturer2 {

    @Produces
    @BMW
    public GermanCar manufactureCar() {
        return new BMWCar();
    }

}
