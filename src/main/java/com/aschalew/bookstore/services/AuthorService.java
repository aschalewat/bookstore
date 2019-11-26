package com.aschalew.bookstore.services;

import com.aschalew.bookstore.domain.Author;

import java.util.List;

public interface AuthorService {

    void addAuthor(Author author);

    Author getAuthor(Long id);

    List<Author> getAuthors();

    void deleteAuthor(Long id);

    void updateAuthor(Author author);
}
