package com.project.medium.services.Impl;

import com.project.medium.model.Blog;
import com.project.medium.repository.BlogRepository;
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
    public Optional<Blog> findById(Long id) {
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

    @Override
    public Blog increaseLike(Blog blog) {
        blog.setAmountOfLikes(blog.getAmountOfLikes()+1);
        blogCrudService.save(blog);
        return blog;
    }

    @Override
    public Blog decreaseLike(Blog blog) {
        blog.setAmountOfLikes(blog.getAmountOfLikes()+1);
        blogCrudService.save(blog);
        return blog;
    }

}
