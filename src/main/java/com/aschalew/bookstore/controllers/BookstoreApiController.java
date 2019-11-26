package com.aschalew.bookstore.controllers;

import com.aschalew.bookstore.domain.Book;
import com.aschalew.bookstore.services.BookstoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookstoreApiController {

    @Autowired
    private BookstoreService bookstoreService;
    private static Logger LOGGER = LoggerFactory.getLogger(BookstoreApiController.class);

    @GetMapping("/books")
    public List<Book> getBooks(){
        LOGGER.debug("Listing books in bookstore.");
        List<Book> bookList = new ArrayList<>();
        bookList = bookstoreService.getAllBooks();

        if (bookList != null){
            return bookList;
        }
        return null;
    }

    public Book getBook(Long id){

        return null;
    }
}
