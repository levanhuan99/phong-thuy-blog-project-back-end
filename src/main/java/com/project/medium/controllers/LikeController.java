package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import com.project.medium.repository.BlogRepository;
import com.project.medium.services.Impl.BlogServiceImpl;
import com.project.medium.services.account.AccountService;
import com.project.medium.services.like.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/likes")
@CrossOrigin("*")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BlogServiceImpl blogService;


    @PostMapping("/add")
    public ResponseEntity<Likes> saveLike(@RequestBody Likes likes) {
        Optional<Account> account = this.accountService.findById(likes.getAccount().getId());
        Optional<Blog> blog = this.blogRepository.findById(likes.getBlog().getId());
        Optional<Likes> likes1 = this.likeService.getLikeByAccountAndBlog(account.get(), blog.get());
        if (!likes1.isPresent()) {
            Likes likes2 = new Likes();
            likes2.setAccount(account.get());
            likes2.setBlog(blog.get());
            likes2.setStatus(true);
            likeService.save(likes2);
            blogService.increaseLike(blog.get());
            return new ResponseEntity<Likes>(likes2, HttpStatus.OK);
        } else {
            if (likes1.get().isStatus()) {
                blogService.decreaseLike(blog.get());
                likes1.get().setStatus(false);
                likeService.save(likes1.get());
            } else {
                blogService.increaseLike(blog.get());
                likes1.get().setStatus(true);
                likeService.save(likes1.get());
            }
            return new ResponseEntity<Likes>(likes1.get(), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}/blog")
    public ResponseEntity<Blog> getAllLikeByBlog(@PathVariable Long id) {
        Optional<Blog> blog = this.blogRepository.findById(id);
        if (blog.isPresent()) {
            return new ResponseEntity<Blog>(blog.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
