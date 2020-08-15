package com.project.medium.services.like;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;

import java.util.List;

public interface ILike {

    List<Likes> getAllLikeByBlog(Blog blog);

    Likes save(Likes likes);
    
    Likes getLikeByAccountAndBlog(Account account,Blog blog);
}
