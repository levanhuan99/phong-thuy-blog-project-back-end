package com.project.medium.controllers.albumImg;


import com.project.medium.model.albumImg.ImageAlbum;

import com.project.medium.services.albumImg.ImageAlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/images")
public class ImageAlbumController {

    @Autowired
    private ImageAlbumServiceImpl imageAlbumService;

    @PostMapping()
    public ResponseEntity<ImageAlbum> createNewImage(@RequestBody ImageAlbum image) {
        if (image == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            ImageAlbum newImage = imageAlbumService.createNewObject(image);
            return new ResponseEntity<>(newImage, HttpStatus.OK);
            }

    }
    @PostMapping("/{id}/delete")
    public ResponseEntity<ImageAlbum> deleteImage (@PathVariable Long id) {
        ImageAlbum  dataImage = imageAlbumService.remove(id);

        if (dataImage==null)  {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(dataImage, HttpStatus.OK);
        }
    }


}
