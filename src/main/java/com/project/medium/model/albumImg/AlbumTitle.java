package com.project.medium.model.albumImg;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
  public class AlbumTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean status;

  @ManyToOne()
  private Account account;
  @OneToMany()
  private List<Image> images;
}