package com.sebastian_daschner.cdi_coffee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.interceptor.Interceptors;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class CoffeePurchaser {

    private Client client;
    private WebTarget target;

    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newBuilder()
                .connectTimeout(100, TimeUnit.MILLISECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();
        target = client.target("http://coffee.example.com/coffee/purchases/");
    }

    @Interceptors({FailureToNullInterceptor.class, CircuitBreaker.class})
    public OrderId purchaseBeans(BeanType type) {
        Object purchase = null;

        CoffeeOrder coffeeOrder = target
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(purchase))
                .readEntity(CoffeeOrder.class);

        return coffeeOrder.getId();
    }

    @PreDestroy
    public void closeClient() {
        client.close();
    }

}
