package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.model.Likes;
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
        this.likeService.save(likes);
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
