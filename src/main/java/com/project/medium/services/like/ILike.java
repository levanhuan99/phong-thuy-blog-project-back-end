package com.project.medium.services.like;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;

import java.util.List;
import java.util.Optional;

public interface ILike {

    List<Likes> getAllLikeByBlog(Blog blog);

    Likes save(Likes likes);
    
    Optional<Likes> getLikeByAccountAndBlog(Account account, Blog blog);
}
