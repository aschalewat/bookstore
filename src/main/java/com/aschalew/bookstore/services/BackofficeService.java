package com.aschalew.bookstore.services;

import com.aschalew.bookstore.model.Book;

import java.util.List;

public interface BackofficeService {



    void addBook(Book book);

    List<Book> getAllBooks();

    void updateBook(Book book);

    boolean deleteBook(Long id);

    Book getBook(Long id);
}
