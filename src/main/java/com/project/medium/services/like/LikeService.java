package com.project.medium.services.like;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService implements ILike {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public List<Likes> getAllLikeByBlog(Blog blog) {
        return this.likeRepository.findAllByBlog(blog);
    }

    @Override
    public Likes save(Likes likes) {
        return this.likeRepository.save(likes);
    }

}
