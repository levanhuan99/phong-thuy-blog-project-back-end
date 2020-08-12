package com.project.medium.model;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Likes {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private boolean likes;



  @ManyToOne(fetch = FetchType.LAZY)
  private Blog blog;


  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;









}