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

    @Column(nullable = false,unique = true)
    private String username; //Se dung nickname lam userName

   @Column(nullable = false,unique = true)
   private String email;

   @Column(nullable = false,unique = true)
    private String phoneNumber;

   @Column(nullable = false)
    private String password;
   @Column(nullable = false)
    private Date birthDay;

   @Column(nullable = false)
    private boolean status; //Su dung status de admin co quyen blog tai khoan nay


    private String avatar;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "account_role",joinColumns = {@JoinColumn(name = "account_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<Role> roles;


}