package com.example.restaurant.orders.boundary;

import com.example.restaurant.events.control.EventConsumer;
import com.example.restaurant.events.entity.MealEvent;
import com.example.restaurant.events.entity.MealFailedNoIngredients;
import com.example.restaurant.events.entity.MealPreparationStarted;
import com.example.restaurant.events.entity.MealPrepared;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.Properties;

@Startup
@Singleton
public class OrderEventHandler {

    private EventConsumer eventConsumer;

    @Resource
    ManagedExecutorService mes;

    @Inject
    Properties kafkaProperties;

    @Inject
    Event<MealEvent> events;

    @Inject
    OrderService orderService;

    public void handle(@Observes MealPreparationStarted event) {
        orderService.startOrder(event.getOrderId());
    }

    public void handle(@Observes MealFailedNoIngredients event) {
        orderService.cancelOrder(event.getOrderId(), "Insufficient ingredients");
    }

    public void handle(@Observes MealPrepared event) {
        orderService.deliverMeal(event.getOrderId());
    }

    @PostConstruct
    private void init() {
        kafkaProperties.put("group.id", "order-handler");
        String chef = kafkaProperties.getProperty("chef.topic");

        eventConsumer = new EventConsumer(kafkaProperties, ev -> events.fire(ev), chef);

        mes.execute(eventConsumer);
    }

    @PreDestroy
    public void close() {
        eventConsumer.stop();
    }

}
