package com.aschalew.bookstore.repository;

import com.aschalew.bookstore.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BookRepository extends CrudRepository<Book, Long> {

    //boolean saveOrUpdate(Book books);
    List<Book> findByCatId(Long catId);
}
