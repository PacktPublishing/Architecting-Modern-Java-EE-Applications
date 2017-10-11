package com.sebastian_daschner.restaurant;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
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

        final URI uri = uriInfo.getRequestUriBuilder()
                // ...
                .build(orderInfo.getOrderId());

        return Response.accepted().header(HttpHeaders.LOCATION, uri).build();
    }

    private OrderInfo createOrderInfo(JsonObject order) {
        return null;
    }

    @GET
    @Path("{id}")
    public JsonObject getOrder(@PathParam("id") UUID orderId) {
//        final MealOrder order = queryService.getOrder(orderId);

//        if (order == null)
//            throw new NotFoundException();

        return Json.createObjectBuilder()
//                .add("status", order.getState().name().toLowerCase())
//                .add("type", order.getOrderInfo().getType().name().toLowerCase())
//                .add("beanOrigin", order.getOrderInfo().getBeanOrigin())
                .build();
    }

}
