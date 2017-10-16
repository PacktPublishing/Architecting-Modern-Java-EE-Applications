package com.example.strategies.cdi;

import javax.enterprise.inject.Produces;
import java.util.function.Function;

public class GreetingStrategyExposer {

    private Function<String, String> formalGreeting = name -> "Dear " + name;
    private Function<String, String> informalGreeting = name -> "Hey " + name;

    @Produces
    public Function<String, String> exposeStrategy() {
        // select a strategy
        Function<String, String> strategy = formalGreeting;

        // ...
        return strategy;
    }

}
