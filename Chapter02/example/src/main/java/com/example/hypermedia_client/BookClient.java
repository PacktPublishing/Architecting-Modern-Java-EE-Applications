package com.example.hypermedia_client;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.net.URI;

public class BookClient {

    @Inject
    EntityMapper entityMapper;

    public Book retrieveBook(URI uri) {
        Entity book = retrieveEntity(uri);
        return entityMapper.decodeBook(uri, book.getProperties());
    }

    public void addToCart(Book book, int quantity) {
        Entity bookEntity = retrieveEntity(book.getUri());

        JsonObjectBuilder properties = Json.createObjectBuilder();
        properties.add("quantity", quantity);

        Entity entity = entityMapper.encodeBook(book);
        entity.getProperties().forEach(properties::add);

        performAction(bookEntity, "add-to-cart", properties.build());
    }

    private Entity retrieveEntity(URI uri) {
        // access URI and map response to entity
        // ...
        return null;
    }

    private void performAction(Entity entity, String actionName, JsonObject properties) {
        // follow action of entity using specific action and properties
        // ...
    }

}
