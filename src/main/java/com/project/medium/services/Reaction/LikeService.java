package com.project.medium.services.Reaction;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;

import java.util.Optional;

public interface LikeService {
    boolean checkLike(Likes likes);

    Optional<Likes> getLikesByAccountAndBlog (Account account, Blog blog);

    void save(Likes likes);
}
