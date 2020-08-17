package com.project.medium.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.medium.model.Blog;
import com.project.medium.model.Comment;
import com.project.medium.model.Likes;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

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

    private String nickName;

   @Column(nullable = false,unique = true)
   private String email;// Dung email de login

   @Column(nullable = false,unique = true)
    private String phoneNumber;

   @Column(nullable = false)
    private String password;


    private Date birthDay;

    private boolean status; //Su dung status de admin co quyen blog tai khoan nay

    @Column(columnDefinition = "TEXT")
    private String avatar;
  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Role> roles;


  @OneToMany(mappedBy = "account")
  @JsonIgnore
  private Set<Blog> blogs;
  //    @ManyToOne
//    private Likes likes;
//
//    @OneToMany
//    private Set<Comment> comments;


    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Likes> likes;
}