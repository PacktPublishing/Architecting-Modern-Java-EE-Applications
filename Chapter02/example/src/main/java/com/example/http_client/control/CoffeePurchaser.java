package com.example.http_client.control;

import com.example.http_client.entity.BeanType;
import com.example.http_client.entity.CoffeeOrder;
import com.example.http_client.entity.OrderId;
import com.example.http_client.entity.Purchase;

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

    @Interceptors(FailureToNullInterceptor.class)
    public OrderId purchaseBeans(BeanType type) {
        // construct purchase payload from type
        // ...
        Purchase purchase = new Purchase();

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
