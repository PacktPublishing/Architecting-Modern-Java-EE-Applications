package com.example.restaurant.events.entity;

import java.time.Instant;
import java.util.UUID;

public class MealPreparationStarted extends MealEvent {

    private final UUID orderId;

    public MealPreparationStarted(UUID orderId) {
        this.orderId = orderId;
    }

    public MealPreparationStarted(UUID orderId, Instant instant) {
        super(instant);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}

