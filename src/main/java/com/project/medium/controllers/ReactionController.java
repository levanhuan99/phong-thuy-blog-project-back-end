package com.project.medium.controllers;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import com.project.medium.services.Impl.BlogCrudService;
import com.project.medium.services.Reaction.CommentCrudService;
import com.project.medium.services.Reaction.LikeService;
import com.project.medium.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/blogs")
public class ReactionController {

//    @Autowired
//    private CommentCrudService commentCrudService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private BlogCrudService blogCrudService;

    @Autowired
    private LikeService likeService;


    @PostMapping("/saveLike/")
    public void saveLike(@RequestBody Likes likes) {
        Optional<Account> account = accountService.getAccountById(likes.getAccount().getId());
        Optional<Blog> blog = blogCrudService.findById(likes.getBlog().getId());
        Optional<Likes> likeStatus1 = likeService.getLikesByAccountAndBlog(account.get(), blog.get());
        if (!likeStatus1.isPresent()) {
            Likes likeStatus2 = new Likes();
            likeStatus2.setAccount(account.get());
            likeStatus2.setBlog(blog.get());
            likeStatus2.setLikes(true);
            likeService.save(likeStatus2);
            blogCrudService.increaseLike(blog.get());
        } else {
            if (likeStatus1.get().isLikes()) {
                blogCrudService.decreaseLike(blog.get());
                likeStatus1.get().setLikes(false);
                likeService.save(likeStatus1.get());
            } else {
                blogCrudService.increaseLike(blog.get());
                likeStatus1.get().setLikes(true);
                likeService.save(likeStatus1.get());
            }
        }

    }

    @GetMapping("/getLike/{id}")
    public int getLikes(@PathVariable Long id) {
        Optional<Blog> blog = blogCrudService.findById(id);
        if (blog.isPresent()) {
            return blog.get().getLikeBlog();
        }
        return 0;
    }






}
