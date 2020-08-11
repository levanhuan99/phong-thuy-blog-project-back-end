package com.project.medium.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean status;

//    @ManyToOne
//    private Blog blog;
//
//    @OneToMany
//  private Set<Account> accounts;
}