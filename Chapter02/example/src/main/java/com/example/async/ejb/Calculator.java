package com.example.async.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.util.Random;

@Stateless
@Asynchronous
public class Calculator {

    public double calculatePi(long decimalPlaces) {
        // this may run for a long time
        // ...
        return new Random().nextDouble();
    }

}
