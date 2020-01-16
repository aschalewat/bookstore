package com.aschalew.bookstore.services;

import com.aschalew.bookstore.model.Book;

import java.util.List;

public interface BookstoreService {

    List<Book> getAllBooks();

    List<Book> getBooks(Long catId);

    Book getBook(Long bookId);
}
