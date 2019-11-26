package com.aschalew.bookstore.repository;

import com.aschalew.bookstore.domain.Book;
import org.springframework.data.repository.CrudRepository;



public interface BookRepository extends CrudRepository<Book, Long> {

    //boolean saveOrUpdate(Book books);
}
