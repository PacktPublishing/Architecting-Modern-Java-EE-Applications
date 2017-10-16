package com.example.restaurant.orders.boundary;

import com.example.restaurant.orders.entity.OrderInfo;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.UUID;

@Path("orders")
public class OrdersCommandResource {

    @Inject
    OrderService orderService;

    @Context
    UriInfo uriInfo;

    @POST
    public Response orderCoffee(JsonObject order) {
        OrderInfo orderInfo = createOrderInfo(order);
        orderService.orderMeal(orderInfo);

        URI uri = uriInfo.getBaseUriBuilder()
                .path(OrdersQueryResource.class)
                .path(OrdersQueryResource.class, "getOrder")
                .build(orderInfo.getOrderId());

        return Response.accepted().header(HttpHeaders.LOCATION, uri).build();
    }

    private OrderInfo createOrderInfo(JsonObject order) {
        // ...
        return new OrderInfo(UUID.randomUUID());
    }

}
