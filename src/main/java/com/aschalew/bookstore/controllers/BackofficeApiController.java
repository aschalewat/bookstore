package com.aschalew.bookstore.controllers;

import com.aschalew.bookstore.domain.Author;
import com.aschalew.bookstore.domain.Book;
import com.aschalew.bookstore.domain.Category;
import com.aschalew.bookstore.domain.User;
import com.aschalew.bookstore.services.AuthorService;
import com.aschalew.bookstore.services.BackofficeService;
import com.aschalew.bookstore.services.CategoryService;
import com.aschalew.bookstore.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backoffice")
public class BackofficeApiController {

    @Autowired
    private BackofficeService backofficeService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private UserService userService;

    private static Logger LOGGER = LoggerFactory.getLogger(BackofficeApiController.class);




    @PostMapping("/books/add")
    public void addBook(@RequestBody Book book){  //@RequestBody Book book
        LOGGER.debug("BackofficeApiController add {}", book.getBookId());
        //@RequestParam("bookId") String id, @RequestParam("title") String title, @RequestParam("price") double price
        Book book1 = new Book();
        if (book != null){
            //book1.setBookId(Long.valueOf(book.getBookId()));
            book1.setTitle(book.getTitle());
            book1.setPrice(Double.valueOf(book.getPrice()));
            book1.setCatId(Long.valueOf(book.getCatId()));
        }

        backofficeService.addBook(book1);
    }
    @GetMapping("/books/list")
    public ResponseEntity<List<Book>> listBooks(){
        LOGGER.debug("BackofficeApiController getAll");
        return ResponseEntity.ok(backofficeService.getAllBooks());
    }

   /* @GetMapping("/books/get/{id}")
    public ResponseEntity<Book> getBook(@PathParam("id") String id){
       return ResponseEntity.ok(backofficeService.getBook(Long.valueOf(id)));
    }*/

    @PostMapping("/books/update")
    public void updateBook(@RequestBody Book book){
        LOGGER.debug("BackofficeApiController update {}", book.getBookId());
       // Book book1 =  new Book();
        if (book != null ){
            /*book1.setBookId(Long.valueOf(book.getBookId()));
            book1.setTitle(book.getTitle());
            book1.setPrice(Double.valueOf(book.getPrice()));
            book1.setCatId(Long.valueOf(book.getCatId()));*/
            backofficeService.updateBook(book);
        }


    }

  @DeleteMapping(value = "/books/delete/{id}")
    public void deleteBook(@RequestParam("id") String id){
      LOGGER.debug("BackofficeApiController delete {}", id);
     boolean ok = backofficeService.deleteBook(Long.valueOf(id));
      System.out.println(ok);
  }

  @PostMapping("/categories/add")
    public void addCategory(@RequestBody Category category){
      LOGGER.debug("BackofficeApiController categories/add {}", category.getName());
        Category category1 = new Category();
        if (category != null){
            category1.setName(category.getName());
        }

       categoryService.addCategory(category1);
  }

  @GetMapping("/categories/list")
    public ResponseEntity<List<Category>> getCategories(){
      LOGGER.debug("BackofficeApiController categories/list");
        return ResponseEntity.ok(categoryService.getCategories());
  }

  @PostMapping("/authors/add")
    public void addAuthor(@RequestBody Author author){
        LOGGER.debug("authors/add {} ", author.getFirstName());
        if (author != null){
            authorService.addAuthor(author);
        }
  }

  @GetMapping("/authors/list")
    public ResponseEntity<List<Author>> getAuthors(){
        LOGGER.debug("/authors/list ");
        LOGGER.debug("authorService.getAuthors() size {}", authorService.getAuthors().size());
        return ResponseEntity.ok(authorService.getAuthors());
  }

  @PostMapping("/cms/login")
    public ResponseEntity<String> login(@RequestBody User user){
        User dbUser = userService.findByUserName(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok("logged in");
        } else if (dbUser != null && ! dbUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok("Wrong Password!");
        } else {
            return ResponseEntity.ok(" No such username exists.");
        }

  }


}
