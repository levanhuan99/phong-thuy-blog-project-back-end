package com.project.medium.services.like;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import com.project.medium.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Likes> getLikeByAccountAndBlog(Account account, Blog blog) {
        return this.likeRepository.findByAccountAndBlog(account, blog);
    }

    public boolean getLikeStatus(Likes likes) {
        if (likes.isStatus()) {
            return true;
        } else {
            return false;
        }
    }

}
