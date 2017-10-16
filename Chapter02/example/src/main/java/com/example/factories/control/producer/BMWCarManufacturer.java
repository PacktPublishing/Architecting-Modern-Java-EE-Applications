package com.example.factories.control.producer;

import com.example.factories.entity.BMW;
import com.example.factories.entity.BMWCar;
import com.example.factories.entity.GermanCar;

import javax.enterprise.inject.Produces;

public class BMWCarManufacturer {

    @Produces
    @BMW
    public GermanCar manufactureCar() {
        return new BMWCar();
    }

}
