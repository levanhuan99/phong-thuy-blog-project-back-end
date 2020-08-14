package com.project.medium.services.like;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;

import java.util.List;

public interface ILike {

    List<Likes> getAllLikeByBlog(Blog blog);

    Likes save(Likes likes);
}
