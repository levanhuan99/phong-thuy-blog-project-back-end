package com.project.medium.model;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Blog {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(nullable = false)
     private String title;

    //Thêm số lươt like của blog
    private int amountOfLikes;

     @Column(columnDefinition = "TEXT")
     private String content;

     private boolean status = true;

//     @Column(nullable = false)
     private Date postTime = Timestamp.valueOf(LocalDateTime.now());

     private String image;

    public Blog() {
    }

    @ManyToOne
    private Account account;

    @ManyToOne
    private Category category;
    //
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Likes> likes;

}