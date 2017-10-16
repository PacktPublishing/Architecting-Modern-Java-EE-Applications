package com.example.restaurant.orders.boundary;

import com.example.restaurant.orders.control.MealOrders;
import com.example.restaurant.orders.entity.MealOrder;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.UUID;

@Path("orders")
public class OrdersQueryResource {

    @Inject
    MealOrders mealOrders;

    @GET
    @Path("{id}")
    public JsonObject getOrder(@PathParam("id") UUID orderId) {
        MealOrder order = mealOrders.get(orderId);

        if (order == null)
            throw new NotFoundException();

        return Json.createObjectBuilder()
                .add("id", order.getOrderId())
                .add("status", order.getState().name())
                // ...
                .add("specification", order.getSpecification().toString())
                .build();
    }

}
