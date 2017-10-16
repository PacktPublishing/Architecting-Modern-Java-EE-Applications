package com.example.strategies.cdi;

import java.time.LocalTime;

public class AfternoonGreetingStrategy implements GreetingStrategy {

    @Override
    public boolean isAppropriate(LocalTime localTime) {
        return false;
    }

    @Override
    public String greet(String name) {
        return "Good afternoon, " + name;
    }

}
