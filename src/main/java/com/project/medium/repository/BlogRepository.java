package com.project.medium.repository;

import com.project.medium.model.Blog;
import com.project.medium.model.auth.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByAccount_IdAndStatus(Long accountId, Boolean status);
    List<Blog> findAllByAccount_Id(Long id);
    List<Blog> findAllByStatus(Boolean status);

//    List<Blog> findAllByAccountIdAndStatusOrAccountIdAndStatus(boolean true, boolean false);
}
