package com.sebastian_daschner.restaurant;

import java.time.Instant;

public class OrderPlaced extends MealEvent {

    private final OrderInfo orderInfo;

    public OrderPlaced(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public OrderPlaced(OrderInfo orderInfo, Instant instant) {
        super(instant);
        this.orderInfo = orderInfo;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }
}

