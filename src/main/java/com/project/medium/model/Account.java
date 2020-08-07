package com.project.medium.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String nickName; //Se dung nickname lam userName
    private String email;
    private String phoneNumber;
    private String password;
    private Date birthDay;
    private boolean status; //Su dung status de admin co quyen blog tai khoan nay
    private byte[] avarta;
    @ManyToMany
    private Set<Role> roles;

}