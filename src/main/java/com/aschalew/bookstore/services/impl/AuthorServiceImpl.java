package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Author;
import com.aschalew.bookstore.repository.AuthorRepository;
import com.aschalew.bookstore.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Value("${firstname.lastname}")
    private String fullName;

    private ScheduledExecutorService scheduledExecutorService;

    @PostConstruct
    public void init() {
        System.out.println("fullname " + fullName);
        System.out.println("I am in init() method.");
        scheduledExecutorService =  Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            sayHallo();
        }, 0, 1, TimeUnit.MINUTES);
        //scheduledExecutorService.scheduleWithFixedDelay()
    }

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

    public void sayHallo() {
        System.out.println("Hallo!");
    }
}
