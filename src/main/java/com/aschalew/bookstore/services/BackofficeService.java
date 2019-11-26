package com.aschalew.bookstore.services;

import com.aschalew.bookstore.domain.Book;

import java.util.List;
import java.util.Map;

public interface BackofficeService {



    void addBook(Book book);

    List<Book> getAllBooks();

    void updateBook(Book book);

    boolean deleteBook(Long id);

    Book getBook(Long id);
}
