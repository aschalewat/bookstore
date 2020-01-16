package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Book;
import com.aschalew.bookstore.services.BookstoreService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreServiceImplTest {

    @Autowired
    private BookstoreService bookstoreService;

    @MockBean
    private Book book;



    @Before
    public void setUp() throws Exception {
    }



    @Ignore
    @Test
    public void getAllBooks() {
        //given
        //given

        //when
        List<Book>  books = bookstoreService.getAllBooks();


        //then
    }
}