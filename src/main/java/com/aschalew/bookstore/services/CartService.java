package com.aschalew.bookstore.services;

import com.aschalew.bookstore.model.Cart;

import java.util.List;

public interface CartService {

    void addCart(Cart cart);

    Cart getCart(Long id);

    List<Cart> getCarts();

    void deleteCart(Long id);

    Cart findByBookId(Long bookId);


}
