package com.project.medium.controllers.albumImg;

import com.project.medium.model.albumImg.AlbumTitle;
import com.project.medium.model.albumImg.Image;
import com.project.medium.services.albumImg.AlbumTitleServiceImpl;
import com.project.medium.services.albumImg.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/albums")
  public class AlbumTitleController {

  @Autowired
  private AlbumTitleServiceImpl albumTitleService;
  @Autowired
  private ImageServiceImpl imagesService;

  @PostMapping()
  public ResponseEntity<AlbumTitle> createAlbumtitle(@RequestBody AlbumTitle albumTitle) {

    if (albumTitle == null) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    AlbumTitle album = new AlbumTitle();
    album.setName(albumTitle.getName());
    album.setAccount(albumTitle.getAccount());
    album.setStatus(albumTitle.getStatus());
    AlbumTitle albumdatabase = albumTitleService.createNewObject(album);

    List<Image> images = albumTitle.getImages();

    for (Image image: images){

      image.setAlbumTitle(albumdatabase);

      imagesService.createNewObject(image);
    }
    return new ResponseEntity<>(albumdatabase, HttpStatus.OK);
  }

  @GetMapping("/account/{id}")
  public ResponseEntity<?> getAlbum(@PathVariable Long id) {

    List <AlbumTitle> albums = albumTitleService.findAllByAccount_Id(id);
    if (albums.size()==0) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    } else {
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

  }

}