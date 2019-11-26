package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.domain.Book;
import com.aschalew.bookstore.repository.BookRepository;
import com.aschalew.bookstore.services.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookstoreServiceImpl implements BookstoreService {
   @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return (List)bookRepository.findAll();
    }
}
