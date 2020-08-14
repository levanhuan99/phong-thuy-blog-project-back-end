package com.project.medium.services.comment;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;

import java.util.List;

public interface IComment {
    List<Comment> findAllCommentByBlog(Blog blog);
    Comment save(Comment comment);
}
