package com.project.medium.model;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Blog {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     private int likeBlog;

     @Column(nullable = false)
     private String title;

     @Column(nullable = false)
     private String content;

     private boolean status = true;

     @Column(nullable = false)
     private Date postTime;

     private String image;

    public Blog() {
    }
     @ManyToOne
     private Account account;
//
     @ManyToOne
    private Category category;

    private int likeBlog() {
        return likeBlog;
    }
}


//
//     @OneToMany
//    private Set<Comment> comments;
//
//     @OneToMany
//    private Set<Likes> likes;

