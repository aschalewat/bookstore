package com.aschalew.bookstore.repository;

import com.aschalew.bookstore.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
