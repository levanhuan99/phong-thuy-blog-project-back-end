package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import com.project.medium.repository.BlogRepository;
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


    @PostMapping("/add")
    public ResponseEntity<Likes> createComment(@RequestBody Likes likes) {
        Likes likes1= this.likeService.getLikeByAccountAndBlog(likes.getAccount(),likes.getBlog());
        boolean likeStatus=this.likeService.getLikeStatus(likes1);
        if (likeStatus){
            likes.getBlog().setAmountOfLikes(likes.getBlog().getAmountOfLikes()-1);
            this.likeService.save(likes);
            likes.setStatus(false);
        }
        else {
            likes.getBlog().setAmountOfLikes(likes.getBlog().getAmountOfLikes()+1);
            this.likeService.save(likes);
            likes.setStatus(true);
        }
        return new ResponseEntity<>(likes,HttpStatus.OK);
    }

    @GetMapping("/{id}/blog")
    public ResponseEntity<List<Likes>> getAllLikes(@PathVariable Long id){
        Optional<Blog> blog=this.blogRepository.findById(id);
        if (blog.isPresent()){
            List<Likes> likesList = this.likeService.getAllLikeByBlog(blog.get());
            return new ResponseEntity<>(likesList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }


}
