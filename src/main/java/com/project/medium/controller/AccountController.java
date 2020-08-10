package com.project.medium.controller;

import com.project.medium.model.auth.Account;
import com.project.medium.model.auth.Role;
import com.project.medium.repository.AccountRepository;
import com.project.medium.repository.RoleRepository;
import com.project.medium.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin("http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Boolean create(@Valid @RequestBody Account account) throws ValidationException {
        Set<Role> roles = new HashSet<Role>();
        String email = account.getEmail();
        if (accountRepository.existsAccountByEmail(email)) {
            throw new ValidationException("Email already existed");
        }
        if(email.equalsIgnoreCase("admin@gmail.com")) {
            Role role = roleRepository.findByName("ROLE_ADMIN");
            roles.add(role);
            account.setRoles(roles);
        } else {
            Role role = roleRepository.findByName("ROLE_USER");
            roles.add(role);
            account.setRoles(roles);
        }
        String password = account.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
        account.setPassword(encodedPassword);
        accountRepository.save(account);
        return true;
    }

    @GetMapping
    public ResponseEntity<Iterable<Account>> getAllAccount(){
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }


}
