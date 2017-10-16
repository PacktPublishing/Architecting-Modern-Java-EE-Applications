package com.example.factories.boundary;

import com.example.factories.control.injection.GermanCarManufacturer;
import com.example.factories.entity.BMW;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarEnthusiast {

    @Inject
    @BMW
    GermanCarManufacturer carManufacturer;

    // ...
}
