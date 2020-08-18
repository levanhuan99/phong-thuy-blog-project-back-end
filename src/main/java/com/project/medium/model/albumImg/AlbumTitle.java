package com.project.medium.model.albumImg;

import com.project.medium.model.auth.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
  @JoinColumn(name = "account_id")
    private Account account;
  @OneToMany(mappedBy = "album_title")
  private List<Image> images;
}