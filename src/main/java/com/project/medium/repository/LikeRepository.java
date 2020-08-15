package com.project.medium.repository;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Likes,Long> {
    List<Likes> findAllByBlog(Blog blog);

    Likes findByAccountAndBlog(Account account,Blog blog);
}
