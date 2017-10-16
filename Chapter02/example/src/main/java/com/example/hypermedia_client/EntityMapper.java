package com.example.hypermedia_client;

import javax.json.Json;
import javax.json.JsonObject;
import java.net.URI;

public class EntityMapper {

    public Entity encodeBook(Book book) {
        // ...
        Entity entity = new Entity();
        entity.setUri(book.getUri());
        entity.setProperties(Json.createObjectBuilder()
                .add("name", book.getName())
                .add("author", book.getAuthor())
                .add("isbn", book.getIsbn())
                .build()
        );
        return entity;
    }

    public Book decodeBook(URI uri, JsonObject properties) {
        // ...
        Book book = new Book();
        book.setUri(uri);
        book.setName(properties.getString("name"));
        book.setAuthor(properties.getString("author"));
        book.setIsbn(properties.getString("isbn"));

        return book;
    }

}
