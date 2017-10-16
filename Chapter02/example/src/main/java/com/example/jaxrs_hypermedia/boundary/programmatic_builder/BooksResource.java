package com.example.jaxrs_hypermedia.boundary.programmatic_builder;

import com.example.jaxrs_hypermedia.entity.Book;
import com.example.jaxrs_hypermedia.boundary.BookStore;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Path("books")
public class BooksResource {

    @Inject
    BookStore bookStore;

    @Context
    UriInfo uriInfo;

    @Inject
    EntityBuilder entityBuilder;

    @GET
    public JsonArray getBooks() {
        return bookStore.getBooks().stream()
                .map((Book book) -> {
                    URI selfUri = uriInfo.getBaseUriBuilder()
                            .path(BooksResource.class)
                            .path(BooksResource.class, "getBook")
                            .build(book.getId());
                    return entityBuilder.buildForBook(book, selfUri);
                })
                .collect(JsonCollectors.toJsonArray());
    }

    @GET
    @Path("{id}")
    public JsonObject getBook(@PathParam("id") long id) {
        Book book = bookStore.getBook(id);
        return buildBookJson(book);
    }

    private JsonObject buildBookJson(Book book) {
        URI selfUri = uriInfo.getBaseUriBuilder()
                .path(BooksResource.class)
                .path(BooksResource.class, "getBook")
                .build(book.getId());

        // ...
        URI authorUri = null;

        return entityBuilder.buildForBook(book, selfUri);
    }

}
