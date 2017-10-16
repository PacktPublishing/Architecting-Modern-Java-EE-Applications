package com.example.strategies.cdi;

import javax.inject.Inject;
import java.util.function.Function;

public class Greeter {

    @Inject
    Function<String, String> greetingStrategy;

    public String greet(String name) {
        return greetingStrategy.apply(name);
    }

}
