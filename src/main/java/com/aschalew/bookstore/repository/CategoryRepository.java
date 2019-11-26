package com.aschalew.bookstore.repository;

import com.aschalew.bookstore.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
