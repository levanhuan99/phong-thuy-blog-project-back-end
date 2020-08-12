package com.project.medium.services.Reaction;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import com.project.medium.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeServiceImpl implements LikeService{

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public boolean checkLike(Likes likes) {
        return likes.isLikes();
    }

    @Override
    public Optional<Likes> getLikesByAccountAndBlog(Account account, Blog blog) {
        return likeRepository.findAllByBlogAndAccount(account,blog);
    }

    @Override
    public void save(Likes likes) {
        likeRepository.save(likes);

    }
}
