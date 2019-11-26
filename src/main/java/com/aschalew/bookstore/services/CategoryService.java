package com.aschalew.bookstore.services;

import com.aschalew.bookstore.domain.Category;

import java.util.List;

public interface CategoryService {

    void addCategory(Category Category);

    Category getCategory(Long catId);

    List<Category> getCategories();

    void deleteCategory(Long id);

    void updateCategory(Category Category);
}
