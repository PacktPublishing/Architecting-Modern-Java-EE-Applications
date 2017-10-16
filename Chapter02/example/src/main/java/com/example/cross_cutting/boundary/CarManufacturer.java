package com.example.cross_cutting.boundary;

import com.example.cross_cutting.control.ProcessTracker;
import com.example.cross_cutting.control.Tracked;
import com.example.cross_cutting.entity.Car;
import com.example.cross_cutting.entity.Specification;

import javax.ejb.Stateless;

@Stateless
public class CarManufacturer {

    @Tracked(ProcessTracker.Category.MANUFACTURER)
    public Car manufactureCar(Specification spec) {
        // ...
        return new Car();
    }

}
