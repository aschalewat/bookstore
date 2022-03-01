package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Book;
import com.aschalew.bookstore.repository.BookRepository;
import com.aschalew.bookstore.services.BackofficeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackofficeServiceImpl implements BackofficeService {

    private static Logger LOGGER = LoggerFactory.getLogger(BackofficeServiceImpl.class);
    @Autowired
    private BookRepository bookRepository;


    @Override
    public void addBook(Book book) {
        System.out.println("BackofficeServiceImpl add");
        Book savedBook = new Book();
        if (book != null){
            savedBook.setTitle(book.getTitle());
            savedBook.setPrice(book.getPrice());
            savedBook.setCatId(book.getCatId());
            savedBook.setAuthorId(book.getAuthorId());
        }
        bookRepository.save(savedBook);
    }

    @Override
    public List<Book> getAllBooks() {
        LOGGER.debug("BackofficeServiceImpl getAll in BOImpl");
        return (List)bookRepository.findAll();
    }

    @Override
    public void updateBook(Book book) {
        LOGGER.debug("BackofficeServiceImpl updateBook in BOImpl");
        Book updatedBook = new Book();
        if (getBook(book.getBookId()) != null){
            updatedBook.setBookId(book.getBookId());
            updatedBook.setTitle(book.getTitle());
            updatedBook.setPrice(book.getPrice());
            updatedBook.setCatId(book.getCatId());
            updatedBook.setAuthorId(book.getAuthorId());
        }
        bookRepository.save(updatedBook);
    }

    @Override
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.delete(getBook(id));
            return true;
        }
        return false;
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).get();
    }


}
