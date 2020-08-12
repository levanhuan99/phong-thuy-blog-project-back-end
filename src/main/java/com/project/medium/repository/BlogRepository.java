package com.project.medium.repository;

import com.project.medium.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByAccount_IdAndStatus(Long accountId, Boolean status);

//    List<Blog> findAllByAccountIdAndStatusOrAccountIdAndStatus(boolean true, boolean false);
}
