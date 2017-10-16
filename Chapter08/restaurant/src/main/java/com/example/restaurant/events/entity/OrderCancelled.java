package com.example.restaurant.events.entity;

import java.util.UUID;

public class OrderCancelled extends MealEvent {

    private final UUID orderId;
    private final String reason;

    public OrderCancelled(UUID orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public String getReason() {
        return reason;
    }

}
