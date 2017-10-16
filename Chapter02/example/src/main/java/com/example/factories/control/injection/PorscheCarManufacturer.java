package com.example.factories.control.injection;

import com.example.factories.entity.GermanCar;
import com.example.factories.entity.Porsche;
import com.example.factories.entity.PorscheCar;

@Porsche
public class PorscheCarManufacturer implements GermanCarManufacturer {

    @Override
    public GermanCar manufactureCar() {
        return new PorscheCar();
    }
}
