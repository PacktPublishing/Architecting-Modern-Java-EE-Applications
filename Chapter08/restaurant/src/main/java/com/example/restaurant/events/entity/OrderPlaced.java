package com.example.restaurant.events.entity;

import com.example.restaurant.orders.entity.OrderInfo;

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

