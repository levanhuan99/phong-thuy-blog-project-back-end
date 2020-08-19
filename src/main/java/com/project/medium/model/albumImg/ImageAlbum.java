package com.project.medium.model.albumImg;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
  public class ImageAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String srcimage;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "album_title_id")
    private AlbumTitle albumTitle;
}