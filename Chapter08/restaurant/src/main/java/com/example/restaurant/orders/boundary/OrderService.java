package com.example.restaurant.orders.boundary;

import com.example.restaurant.events.control.EventProducer;
import com.example.restaurant.events.entity.MealDelivered;
import com.example.restaurant.events.entity.OrderCancelled;
import com.example.restaurant.events.entity.OrderPlaced;
import com.example.restaurant.events.entity.OrderStarted;
import com.example.restaurant.orders.entity.OrderInfo;

import javax.inject.Inject;
import java.util.UUID;

public class OrderService {

    @Inject
    EventProducer eventProducer;

    public void orderMeal(OrderInfo orderInfo) {
        eventProducer.publish(new OrderPlaced(orderInfo));
    }

    void cancelOrder(UUID orderId, String reason) {
        eventProducer.publish(new OrderCancelled(orderId, reason));
    }

    void startOrder(UUID orderId) {
        eventProducer.publish(new OrderStarted(orderId));
    }

    void deliverMeal(UUID orderId) {
        eventProducer.publish(new MealDelivered(orderId));
    }

}
