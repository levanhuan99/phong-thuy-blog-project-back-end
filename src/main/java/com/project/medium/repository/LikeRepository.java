package com.project.medium.repository;

import com.project.medium.model.Blog;
import com.project.medium.model.Likes;
import com.project.medium.model.auth.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface LikeRepository extends CrudRepository<Likes,Long> {

      Optional<Likes> findAllByBlogAndAccount(Account account, Blog blog);


}
