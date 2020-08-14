package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.repository.BlogRepository;
import com.project.medium.services.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comments")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    BlogRepository blogRepository;



    @PostMapping("/add")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        this.commentService.save(comment);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }

    @GetMapping("/{id}/blog")
    public ResponseEntity<List<Comment>> getAllComment(@PathVariable Long id) {
        Optional<Blog> blog=this.blogRepository.findById(id);
        if (blog.isPresent()){
            List<Comment> commentList = this.commentService.findAllCommentByBlog(blog.get());
            return new ResponseEntity<>(commentList,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
