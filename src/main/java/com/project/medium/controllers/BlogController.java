package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.services.BlogCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class BlogController {
    private BlogCrudService blogCrudService;

    @Autowired
    public BlogController(BlogCrudService blogCrudService) {
        this.blogCrudService = blogCrudService;
    }


    @RequestMapping(value = "api/blogs/list", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> findAllBlog() {
        List<Blog> blogs = blogCrudService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @RequestMapping(value = "api/blogs/{id}/search",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlogById(
            @PathVariable("id") Long id) {
        Optional<Blog> blog = blogCrudService.findById(id);

        if (!blog.isPresent()) {
            return new ResponseEntity<>(blog.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blog.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "api/blogs/create",
            method = RequestMethod.POST)
    public ResponseEntity<Blog> createBlog( @RequestBody Blog blogs,
            UriComponentsBuilder builder) {
        blogCrudService.save(blogs);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("api/blogs/{id}")
                .buildAndExpand(blogs.getId()).toUri());
        return new ResponseEntity<>(blogs, HttpStatus.CREATED);
    }

    @RequestMapping(value = "api/blogs/{id}/edit",
            method = RequestMethod.PUT)
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Long id, @RequestBody Blog blog) {
        Optional<Blog> currentBlog = blogCrudService
                .findById(id);
        if (!currentBlog.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

//        currentBlog.get().setId(id);
        currentBlog.get().setTitle(blog.getTitle());
        currentBlog.get().setContent(blog.getContent());
        currentBlog.get().setStatus(blog.isStatus());
        currentBlog.get().setPostTime(blog.getPostTime());

//        currentBlog.get().setCategory(blog.getCategory());
//        currentBlog.get().setAccount(blog.getAccount());
        blogCrudService.save(currentBlog.get());
        return new ResponseEntity<>(currentBlog.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "api/blogs/{id}/delete",
            method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog( @PathVariable("id") Long id) {

        Optional<Blog> blog = blogCrudService.findById(id);

        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogCrudService.delete(blog.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

