package com.aschalew.bookstore.repository;

import com.aschalew.bookstore.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

    Cart findByBookId(Long bookId);
}
