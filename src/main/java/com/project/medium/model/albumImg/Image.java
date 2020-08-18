package com.project.medium.model.albumImg;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
  public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String srcimage;
    @ManyToOne()
    private AlbumTitle albumTitle;
}