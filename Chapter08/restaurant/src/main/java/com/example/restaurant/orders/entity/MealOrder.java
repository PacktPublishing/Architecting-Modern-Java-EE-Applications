package com.example.restaurant.orders.entity;

import javax.persistence.*;

@Entity
@Table(name = "meal_orders")
public class MealOrder {

    @Id
    private String orderId;

    @Embedded
    private MealSpecification specification;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    private MealOrder() {
    }

    public MealOrder(OrderInfo orderInfo) {
        orderId = orderInfo.getOrderId().toString();
        state = OrderState.PLACED;

        // define specifications
    }

    public void start() {
        state = OrderState.STARTED;
    }

    public void deliver() {
        state = OrderState.DELIVERED;
    }

    public void cancel() {
        state = OrderState.CANCELLED;
    }

    public String getOrderId() {
        return orderId;
    }

    public MealSpecification getSpecification() {
        return specification;
    }

    public OrderState getState() {
        return state;
    }

}
