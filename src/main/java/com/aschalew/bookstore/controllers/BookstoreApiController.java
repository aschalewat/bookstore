package com.aschalew.bookstore.controllers;

import com.aschalew.bookstore.model.Book;
import com.aschalew.bookstore.model.Cart;
import com.aschalew.bookstore.services.BookstoreService;
import com.aschalew.bookstore.services.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bookstore")
public class BookstoreApiController {

    @Autowired
    private BookstoreService bookstoreService;
    @Autowired
    private CartService cartService;
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

    @GetMapping("/categories/{catId}/books")
    ResponseEntity<List<Book>> getBooks(@RequestParam("catId") Long catId) {
        LOGGER.debug("Listing books for the category{}", catId);
        List<Book> books = bookstoreService.getBooks(catId);
        if (books != null) {
            return ResponseEntity.ok(books);
        }
        return null;
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> getBook(@RequestParam("bookId")Long bookId) {
        LOGGER.debug("Get book for the bookId{}", bookId);
        Book book = bookstoreService.getBook(bookId);
        if (book != null){
            return ResponseEntity.ok(book);
        }
        return null;
    }


    @GetMapping("/cart/{cartId}")
    public ResponseEntity<Cart> getCart(@RequestParam("cartId") Long cartId) {
        LOGGER.debug("Get cart for the cartId{}", cartId);
        Cart cart = cartService.getCart(cartId);
        if (cart != null) {
            return ResponseEntity.ok(cart);
        }
        return null;
    }

    @PostMapping("/cart/add")
    public void addCart(@RequestBody Cart cart){
        LOGGER.debug("Add book{} cart ", cart.getBookId());
        Cart newCart = new Cart();
        Cart existingCartForBook = cartService.findByBookId(cart.getBookId());
        if (cart != null) {
            if (existingCartForBook == null){
                newCart.setBookId(cart.getBookId());
                newCart.setPrice(cart.getPrice());
                newCart.setAmount(cart.getAmount());
                newCart.setTotal(cart.getAmount() * cart.getPrice());
                newCart.setDate(cart.getDate());
                newCart.setStatus("IN_CART");
            } else {
                newCart.setId(existingCartForBook.getId());
                newCart.setBookId(cart.getBookId());
                newCart.setPrice(cart.getPrice());
                newCart.setDate(cart.getDate());
                int newAmount = cart.getAmount() + existingCartForBook.getAmount();
                newCart.setAmount(newAmount);
                newCart.setTotal(newAmount * cart.getPrice());
                newCart.setStatus("IN_CART");
            }

        }

        cartService.addCart(newCart);
    }

    @GetMapping("/cart/list")
    public ResponseEntity<List<Cart>> getCartList() {
        LOGGER.debug("Get cart list");
        List<Cart> carts = cartService.getCarts();
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/cart/delete/{cartId}")
    public void delete(@RequestParam("cartId") Long cartId) {
        LOGGER.debug("Deleting cart{}", cartId);
        cartService.deleteCart(cartId);
    }
}
