package com.sebastian_daschner.restaurant;

import javax.inject.Inject;
import java.util.UUID;

public class OrderService {

    @Inject
    EventProducer eventProducer;

    public void orderMeal(OrderInfo orderInfo) {
        eventProducer.publish(new OrderPlaced(orderInfo));
    }

    void cancelOrder(final UUID orderId, final String reason) {
        eventProducer.publish(new OrderCancelled(orderId, reason));
    }

    void startOrder(final UUID orderId) {
        eventProducer.publish(new OrderStarted(orderId));
    }

    void deliverMeal(final UUID orderId) {
        eventProducer.publish(new MealDelivered(orderId));
    }

}
