package com.aschalew.bookstore.controllers;

import com.aschalew.bookstore.model.Author;
import com.aschalew.bookstore.model.Book;
import com.aschalew.bookstore.model.Category;
import com.aschalew.bookstore.model.User;
import com.aschalew.bookstore.services.AuthorService;
import com.aschalew.bookstore.services.BackofficeService;
import com.aschalew.bookstore.services.CategoryService;
import com.aschalew.bookstore.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            book1.setAuthorId(book.getAuthorId());
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

  @PostMapping("users/add")
  public void addUser(@RequestBody User user){
      LOGGER.debug("/users/add {}", user.getUsername());
        if (user != null){
            userService.addUser(user);
        }
  }

  @GetMapping("/users/list")
  public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.gerUsers());
  }

  @PostMapping("/users/update")
  public void updateUser(User user){
        if (user != null){
            userService.updateUser(user);
        }
  }

  @PostMapping("/cms/login")
    public ResponseEntity<HttpStatus> login(@RequestBody User user){
        User dbUser = userService.findByUserName(user.getUsername());
        LOGGER.debug("login" + user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
           // goToLogin();
            LOGGER.debug("user {} successfully logged in! ", user.getUsername());
            return ResponseEntity.ok(HttpStatus.ACCEPTED);
        } else if (dbUser != null && ! dbUser.getPassword().equals(user.getPassword())){
            LOGGER.debug("Password doesn't match");
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        } else {
            LOGGER.debug("This user doesn't exist! ");
            return ResponseEntity.badRequest().body(HttpStatus.BAD_REQUEST);
        }

  }

  @GetMapping()
    public void goToLogin(){

  }


}
