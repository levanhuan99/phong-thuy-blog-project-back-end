package com.project.medium.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
  public class Blog {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     private String title;
     private String content;
     private boolean status;
     private Date postTime;
     private String image;
     @ManyToOne
     private Account account;
     @ManyToOne
    private Category category;

  }