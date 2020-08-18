package com.project.medium.controllers.albumImg;


import com.project.medium.model.albumImg.Image;

import com.project.medium.services.albumImg.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/images")
public class ImageAlbumController {

    @Autowired
    private ImageServiceImpl imageAlbumService;

    @PostMapping()
    public ResponseEntity<Image> createNewImage(@RequestBody Image image) {
        if (image == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            Image newImage = imageAlbumService.createNewObject(image);
            return new ResponseEntity<>(newImage, HttpStatus.OK);
            }

    }
    @GetMapping("/album/{id}")
    public ResponseEntity<?> listImage(@PathVariable Long id){
        List<Image> listImageByAlbumtle_id =
                imageAlbumService.findAllByAlbumTitle_Id(id);
        if (listImageByAlbumtle_id.size()==0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Image>>(listImageByAlbumtle_id, HttpStatus.OK);
        }
    }

    @PostMapping("/{id}/delete")
    public ResponseEntity<Image> deleteImage (@PathVariable Long id) {
        Image dataImage = imageAlbumService.remove(id);

        if (dataImage==null)  {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {

            return new ResponseEntity<>(dataImage, HttpStatus.OK);
        }
    }

}
