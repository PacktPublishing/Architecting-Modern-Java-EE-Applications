package com.example.strategies.cdi;

import java.time.LocalTime;

public class MorningGreetingStrategy implements GreetingStrategy {

    @Override
    public boolean isAppropriate(LocalTime localTime) {
        return false;
    }

    @Override
    public String greet(String name) {
        return "Good morning, " + name;
    }

}
