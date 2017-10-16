package com.example.restaurant.events.entity;

import java.time.Instant;
import java.util.Objects;

public abstract class MealEvent {

    private final Instant instant;

    protected MealEvent() {
        instant = Instant.now();
    }

    protected MealEvent(Instant instant) {
        Objects.requireNonNull(instant);
        this.instant = instant;
    }

    public Instant getInstant() {
        return instant;
    }
}

