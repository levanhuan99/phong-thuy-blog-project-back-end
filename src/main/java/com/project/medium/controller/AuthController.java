package com.project.medium.controller;

import com.project.medium.model.auth.Account;
import com.project.medium.model.auth.JwtResponse;
import com.project.medium.service.JwtService;
import com.project.medium.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

@RestController
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getEmail(), account.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentAccount = accountService.findByEmail(account.getEmail()).get();
        return ResponseEntity.ok(new JwtResponse(jwt,currentAccount.getId(), userDetails.getUsername(), currentAccount.getNickName(),userDetails.getAuthorities()));
    }

//    @PostMapping("/register")
//    public ResponseEntity<Account> register(@RequestBody Account account) {
//        Iterable<Account> accounts=accountService.findAll();
//        for (Account a: accounts){
//            if (a.getEmail().equals(account.getEmail())){
//                return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            }
//        }
//        accountService.save(account);
//        return new ResponseEntity<>(account, HttpStatus.OK);
//    }
}
