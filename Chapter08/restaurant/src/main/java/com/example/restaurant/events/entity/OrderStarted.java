package com.example.restaurant.events.entity;

import java.time.Instant;
import java.util.UUID;

public class OrderStarted extends MealEvent {

    private final UUID orderId;

    public OrderStarted(UUID orderId) {
        this.orderId = orderId;
    }

    public OrderStarted(UUID orderId, Instant instant) {
        super(instant);
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }

}
