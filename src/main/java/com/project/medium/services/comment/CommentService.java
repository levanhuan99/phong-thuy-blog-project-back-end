package com.project.medium.services.comment;


import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements IComment{

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public List<Comment> findAllCommentByBlog(Blog blog) {
        return commentRepository.findAllByBlog(blog);
    }

    @Override
    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    }
}
