package com.example.restaurant.events.entity;

import java.time.Instant;
import java.util.UUID;

public class MealFailedNoIngredients extends MealEvent {

    private final UUID orderId;

    public MealFailedNoIngredients(UUID orderId) {
        this.orderId = orderId;
    }

    public MealFailedNoIngredients(UUID orderId, Instant instant) {
        super(instant);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}

