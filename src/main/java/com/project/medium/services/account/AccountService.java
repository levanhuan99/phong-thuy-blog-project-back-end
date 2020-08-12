package com.project.medium.services.account;

import com.project.medium.model.auth.Account;
import com.project.medium.model.auth.AccountPrinciple;
import com.project.medium.model.auth.Role;
import com.project.medium.repository.AccountRepository;
import com.project.medium.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService implements IAccount{
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Optional<Account> findByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }


    @Override
    public Account save(Account account) {
        if(account.getRoles() == null) {
            Role role = roleService.findByName("ROLE_USER");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            account.setRoles(roles);
        }

        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }

    @Override
    public void remove(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepository.findByEmail(username);
        if (!accountOptional.isPresent()){
            throw new UsernameNotFoundException(username);
        }
        return AccountPrinciple.build(accountOptional.get());
    }
}
