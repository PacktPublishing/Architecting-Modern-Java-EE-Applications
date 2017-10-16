package com.example.strategies.cdi;

import java.time.LocalTime;

public interface GreetingStrategy {

    boolean isAppropriate(LocalTime localTime);

    String greet(String name);

}

