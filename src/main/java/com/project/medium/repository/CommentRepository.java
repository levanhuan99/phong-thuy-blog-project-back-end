package com.project.medium.repository;

import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

    List<Comment> findAllByBlog(Blog blog);

}
