package com.project.medium.model.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToMany
    private Set<Account> accounts;

    public Role(Long id, String role_admin) {
      this.id = id;
      this.name = role_admin;
    }

  public Role(Long id) {
    this.id = id;
  }

  public Role() {

  }

  //Mọi người hãy tạo dữ liệu cững cho bảng role này nhé:
 /* use medium;
    insert into role(id, name)
    values (1,'ROLE_ADMIN'),
       (2,'ROLE_USER');

  */
}