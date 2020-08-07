package com.project.medium.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
  public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

 //Mọi người hãy tạo dữ liệu cững cho bảng role này nhé:
 /* use medium;
    insert into role(id, name)
    values (1,'ROLE_ADMIN'),
       (2,'ROLE_USER');

  */
}