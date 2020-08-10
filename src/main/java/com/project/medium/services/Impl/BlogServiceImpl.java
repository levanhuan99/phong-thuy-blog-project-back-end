package com.project.medium.services.Impl;

import com.project.medium.model.Blog;
import com.project.medium.repositories.BlogRepository;
import com.project.medium.services.BlogCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BlogServiceImpl  implements BlogCrudService {

    private BlogCrudService blogCrudService;

    @Autowired
    private BlogRepository blogRepository;



    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void delete(Blog blog) {
        blogRepository.delete(blog);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }
}
