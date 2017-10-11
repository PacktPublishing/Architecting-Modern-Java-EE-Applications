package com.sebastian_daschner.restaurant;

import java.time.Instant;
import java.util.UUID;

public class MealDelivered extends MealEvent {

    private final UUID orderId;

    public MealDelivered(UUID orderId) {
        this.orderId = orderId;
    }

    public MealDelivered(UUID orderId, Instant instant) {
        super(instant);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }
}

