package com.aschalew.bookstore.services.impl;

import com.aschalew.bookstore.model.Category;
import com.aschalew.bookstore.repository.CategoryRepository;
import com.aschalew.bookstore.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void addCategory(Category Category) {
        categoryRepository.save(Category);
    }

    @Override
    public Category getCategory(Long catId) {
        if (categoryRepository.existsById(catId)){
            return categoryRepository.findById(catId).get();
        }
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return (List) categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long catId) {
        Category cat = categoryRepository.findById(catId).get();
        if (cat != null){
            categoryRepository.delete(cat);
        }
    }

    @Override
    public void updateCategory(Category Category) {
        if (categoryRepository.existsById(Category.getCatId())){
            categoryRepository.save(Category);
        }
    }
}
