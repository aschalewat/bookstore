package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Author;
import com.aschalew.bookstore.repository.AuthorRepository;
import com.aschalew.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public Author getAuthor(Long id) {
        if (authorRepository.existsById(id)){
            return authorRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public List<Author> getAuthors() {
        return (List)authorRepository.findAll();
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).get();
        if (author != null) {
            authorRepository.delete(author);
        }
    }

    @Override
    public void updateAuthor(Author author) {
        if (authorRepository.existsById(author.getId())) {
            authorRepository.save(author);
        }
    }
}
