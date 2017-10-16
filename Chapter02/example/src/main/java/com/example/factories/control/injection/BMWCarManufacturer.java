package com.example.factories.control.injection;

import com.example.factories.entity.BMW;
import com.example.factories.entity.BMWCar;
import com.example.factories.entity.GermanCar;

@BMW
public class BMWCarManufacturer implements GermanCarManufacturer {

    @Override
    public GermanCar manufactureCar() {
        return new BMWCar();
    }
}
