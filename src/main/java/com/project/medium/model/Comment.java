package com.project.medium.model;

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

    private String content;

//    @ManyToOne
//    private Account account;
//
//    @ManyToOne
//    private Blog blog;
}