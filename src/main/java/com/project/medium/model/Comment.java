package com.project.medium.model;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
  public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date commentTime= Timestamp.valueOf(LocalDateTime.now());
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    private Blog blog;
}