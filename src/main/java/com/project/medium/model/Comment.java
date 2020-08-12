package com.project.medium.model;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Comment {

  @Id

  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;


  private Date commentTime;

  @Column(columnDefinition = "Text")
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  private Account account;

  @ManyToOne(fetch = FetchType.LAZY)
  private Blog blog;

//    @ManyToOne
//    private Account account;
//
//    @ManyToOne
//    private Blog blog;
}