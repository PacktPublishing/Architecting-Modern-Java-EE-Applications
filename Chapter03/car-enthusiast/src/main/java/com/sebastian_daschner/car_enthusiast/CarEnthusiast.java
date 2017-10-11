package com.sebastian_daschner.car_enthusiast;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarEnthusiast {

    @Inject
    @BMW
    GermanCarManufacturer carManufacturer;

    // ...
}
