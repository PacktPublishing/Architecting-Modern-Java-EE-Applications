package com.example.jaxrs_hypermedia.boundary.programmatic_builder;

import com.example.jaxrs_hypermedia.entity.Book;

import javax.json.Json;
import javax.json.JsonObject;
import java.net.URI;

public class EntityBuilder {

    public JsonObject buildForBook(Book book, URI selfUri) {
        return Json.createObjectBuilder()
                .add("name", book.getName())
                .add("author", book.getName())
                .add("isbn", book.getName())
                .add("_links", Json.createObjectBuilder()
                        .add("self", selfUri.toString()))
                .build();
    }

}
