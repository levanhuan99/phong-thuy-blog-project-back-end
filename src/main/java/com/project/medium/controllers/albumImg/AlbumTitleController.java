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
    AlbumTitle newAlbum = albumTitleService.createNewObject(albumTitle);
    List<Image> images = albumTitle.getImages();
    for (Image image: images){
      imagesService.createNewObject(image);
    }
    return new ResponseEntity<>(newAlbum, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getAlbum(@PathVariable Long id) {
    AlbumTitle albumTitle = albumTitleService.findById(id);
    return new ResponseEntity<AlbumTitle>(albumTitle, HttpStatus.OK);


  }

}