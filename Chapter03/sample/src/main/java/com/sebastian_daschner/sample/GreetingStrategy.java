package com.sebastian_daschner.sample;

import java.time.LocalTime;

public interface GreetingStrategy {
    boolean isAppropriate(LocalTime localTime);
    String greet(String name);
}

class MorningGreetingStrategy implements GreetingStrategy {
    @Override
    public boolean isAppropriate(LocalTime localTime) {
        return false;
    }

    @Override
    public String greet(String name) {
        return "Good morning, " + name;
    }
}

class AfternoonGreetingStrategy implements GreetingStrategy {
    @Override
    public boolean isAppropriate(LocalTime localTime) {
        return false;
    }

    @Override
    public String greet(String name) {
        return "Good afternoon, " + name;
    }
}

class EveningGreetingStrategy implements GreetingStrategy {
    @Override
    public boolean isAppropriate(LocalTime localTime) {
        return false;
    }

    @Override
    public String greet(String name) {
        return "Good evening, " + name;
    }
}

