package com.example.jaxrs_hypermedia.boundary;

import com.example.jaxrs_hypermedia.entity.Book;

import java.util.List;

import static java.util.Arrays.asList;

public class BookStore {

    public List<Book> getBooks() {
        return asList(new Book());
    }

    public Book getBook(long id) {
        Book book = new Book();
        book.setId(id);
        return book;
    }

}
