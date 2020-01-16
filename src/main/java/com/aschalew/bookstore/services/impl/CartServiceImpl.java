package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Cart;
import com.aschalew.bookstore.repository.CartRepository;
import com.aschalew.bookstore.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl  implements CartService {
    @Autowired
    private CartRepository cartRepository;


    @Override
    public void addCart(Cart cart) {
       // if (cart != null && cart.getId() == null) {
            cartRepository.save(cart);
       /* } else if (cart.getId() != null) {
            Cart newCart = new Cart();
            newCart.
        }*/

    }

    @Override
    public Cart getCart(Long id) {
        return cartRepository.findById(id).get();
    }

    @Override
    public List<Cart> getCarts() {
        return (List)cartRepository.findAll();
    }

    @Override
    public void deleteCart(Long id) {
        Cart cart = getCart(id);
        if (cart != null) {
            cartRepository.delete(cart);
        }
    }

    @Override
    public Cart findByBookId(Long bookId) {
        return cartRepository.findByBookId(bookId);
    }
}
