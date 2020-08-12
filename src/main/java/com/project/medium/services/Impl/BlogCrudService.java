package com.project.medium.services.Impl;

import com.project.medium.model.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogCrudService {
    List<Blog> findAll();

    Optional<Blog> findById(Long id);

    void delete(Blog blog);

    void save(Blog blog);
}
