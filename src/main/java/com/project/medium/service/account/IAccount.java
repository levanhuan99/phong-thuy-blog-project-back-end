package com.project.medium.service.account;

import com.project.medium.model.auth.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAccount extends UserDetailsService {
    Optional<Account> findByEmail(String email);
    Iterable<Account> findAll();
    Optional<Account> findById(Long id);

    Account save(Account account);
    void remove(Long id);
}
