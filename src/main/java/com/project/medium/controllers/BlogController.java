package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.BlogResponse;
import com.project.medium.repository.BlogRepository;
import com.project.medium.services.BlogCrudService;
import com.project.medium.services.category.CategoryService;
import com.project.medium.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/blogs")
public class BlogController {
    private BlogCrudService blogCrudService;

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CommentService commentService;

    @Autowired
    public BlogController(BlogCrudService blogCrudService) {
        this.blogCrudService = blogCrudService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<BlogResponse>> findAllBlog() {
        List<Blog> blogs = blogRepository.findAllByStatus(true);
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (blogs!=null){
            Collections.reverse(blogs);
        }
        List<BlogResponse> responses = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogResponse response = new BlogResponse();
            response.setTitle(blog.getTitle());
            response.setId(blog.getId());
            response.setLikes(blog.getAmountOfLikes());
            response.setNameCategory(blog.getCategory().getName());
            response.setAccountId(blog.getAccount().getId());
            response.setPostTime(blog.getPostTime());
            response.setAvatarUrl(blog.getAccount().getAvatar());
            response.setAmountComment(commentService.findAllCommentByBlog(blog).size());
            responses.add(response);
        }
        if (responses != null){
            Collections.reverse(responses);
        }
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

//    @RequestMapping(value = "/list-all-me",method = RequestMethod.GET)
//    public ResponseEntity<List<Blog>> findAllBlogOfMe(){
//        List<Blog> blogList = blogCrudService.findAll();
//        if (blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        if (blogList != null){
//            Collections.reverse(blogList);
//        }
//        return new ResponseEntity<>(blogList,HttpStatus.OK);
//    }

    @RequestMapping(value = "/get-blog/{id}",
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

    @RequestMapping(value = "/create",
            method = RequestMethod.POST)
    public ResponseEntity<Blog> createBlog(@RequestBody Blog blogs,
                                           UriComponentsBuilder builder) {
        blogCrudService.save(blogs);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/{id}")
                .buildAndExpand(blogs.getId()).toUri());
        return new ResponseEntity<>(blogs, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/edit",
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

        currentBlog.get().setCategory(blog.getCategory());
//        currentBlog.get().setAccount(blog.getAccount());
        blogCrudService.save(currentBlog.get());
        return new ResponseEntity<>(currentBlog.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/delete",
            method = RequestMethod.DELETE)
    public ResponseEntity<Blog> deleteBlog( @PathVariable("id") Long id) {

        Optional<Blog> blog = blogCrudService.findById(id);

        if (!blog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogCrudService.delete(blog.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{accountId}/list")
    public ResponseEntity<List<BlogResponse>> getBlogByAccountId(@PathVariable Long accountId){
        List<Blog> blogList = blogRepository.findAllByAccount_IdAndStatus(accountId, true);
        List<BlogResponse> responses = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogResponse response = new BlogResponse();
            response.setTitle(blog.getTitle());
            response.setId(blog.getId());
            response.setLikes(blog.getAmountOfLikes());
            response.setNameCategory(blog.getCategory().getName());
            response.setAccountId(blog.getAccount().getId());
            response.setPostTime(blog.getPostTime());
            response.setAvatarUrl(blog.getAccount().getAvatar());
            response.setAmountComment(commentService.findAllCommentByBlog(blog).size());
            responses.add(response);
        }
        if (responses != null){
            Collections.reverse(responses);
        }
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @GetMapping("/{accountId}/listAll")
    public ResponseEntity<List<BlogResponse>> getAllByAccountId(@PathVariable Long accountId){
        List<Blog> blogList = blogRepository.findAllByAccount_Id(accountId);
        List<BlogResponse> responses = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogResponse response = new BlogResponse();
            response.setTitle(blog.getTitle());
            response.setId(blog.getId());
            response.setLikes(blog.getAmountOfLikes());
            response.setNameCategory(blog.getCategory().getName());
            response.setAccountId(blog.getAccount().getId());
            response.setPostTime(blog.getPostTime());
            response.setAvatarUrl(blog.getAccount().getAvatar());
            response.setAmountComment(commentService.findAllCommentByBlog(blog).size());
            responses.add(response);
        }
        if (responses != null){
            Collections.reverse(responses);
        }
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }

    @GetMapping("/{categoryId}/list-category")
    public ResponseEntity<List<BlogResponse>> getAllBlogByCategoryId(@PathVariable Long categoryId){
        List<Blog> blogList = blogCrudService.findAllByCategory_IdAndStatus(categoryId,true);
        List<BlogResponse> responses = new ArrayList<>();
        for (Blog blog : blogList) {
            BlogResponse response = new BlogResponse();
            response.setTitle(blog.getTitle());
            response.setId(blog.getId());
            response.setLikes(blog.getAmountOfLikes());
            response.setNameCategory(blog.getCategory().getName());
            response.setAccountId(blog.getAccount().getId());
            response.setPostTime(blog.getPostTime());
            response.setAvatarUrl(blog.getAccount().getAvatar());
            response.setAmountComment(commentService.findAllCommentByBlog(blog).size());
            responses.add(response);
        }
        if (responses != null){
            Collections.reverse(responses);
        }
        return new ResponseEntity<>(responses,HttpStatus.OK);
    }
}

