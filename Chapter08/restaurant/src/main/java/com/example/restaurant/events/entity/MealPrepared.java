package com.example.restaurant.events.entity;

import java.time.Instant;
import java.util.UUID;

public class MealPrepared extends MealEvent {

    private final UUID orderId;

    public MealPrepared(UUID orderId) {
        this.orderId = orderId;
    }

    public MealPrepared(UUID orderId, Instant instant) {
        super(instant);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}

