package com.org.unixam_backend.service;

import com.org.unixam_backend.model.exam.Category;

import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategory(Long categoryId);
    public void delete(Long categoryId);
}
