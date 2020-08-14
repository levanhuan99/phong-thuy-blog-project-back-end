package com.project.medium.controllers;

import com.project.medium.model.auth.Account;
import com.project.medium.model.auth.Role;
import com.project.medium.repository.AccountRepository;
import com.project.medium.repository.RoleRepository;
import com.project.medium.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.bind.ValidationException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("api/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/create")
    public Boolean create(@Valid @RequestBody Account account) throws ValidationException {
        Set<Role> roles = new HashSet<Role>();
        //Thuy tem avatar default
        account.setAvatar("https://firebasestorage.googleapis.com/v0/b/uploadfile-demo-20e6f.appspot.com/o/avatar_account_default_1597306792462?alt=media&token=61bed8e9-9719-48ea-b7b5-5cdb0f03b6db");

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


    @RequestMapping(value = "/{id}/edit",
            method = RequestMethod.PUT)
    public ResponseEntity<Account> updateBlog(@PathVariable("id") Long id, @RequestBody Account account) {
        Account currentAccount = accountService.findById(id).orElse(null);
        if (currentAccount == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        currentAccount.setNickName(account.getNickName());
//        currentAccount.setRoles(account.getRoles());
        currentAccount.setStatus(account.isStatus());
        currentAccount.setAvatar(account.getAvatar());
        currentAccount.setPassword(account.getPassword());
        currentAccount.setEmail(account.getEmail());
        currentAccount.setFirstName(account.getFirstName());
        currentAccount.setLastName(account.getLastName());
        currentAccount.setPhoneNumber(account.getPhoneNumber());
        currentAccount.setBirthDay(account.getBirthDay());
        accountService.save(currentAccount);
        return new ResponseEntity<>(currentAccount, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/delete",
            method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteBlog( @PathVariable("id") Long id) {

        Optional<Account> account = accountService.findById(id);

        if (!account.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    //Thuy them code
    @GetMapping("/{id}/details")
    public ResponseEntity<Account> getAccountDetails(@PathVariable Long id) {
        Account account = accountService.findById(id).orElse(null);
        if (account == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(account,HttpStatus.OK);
        }

    }
}
