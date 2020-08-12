package com.project.medium.services.category;

import com.project.medium.model.Category;

public interface ICategory {

    Iterable<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    void remove(Long id);
}
