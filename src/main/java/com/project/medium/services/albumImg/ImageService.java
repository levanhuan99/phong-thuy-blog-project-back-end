package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.Image;
import com.project.medium.services.GenericService;

import java.util.List;


public interface ImageService extends GenericService<Image> {
    List<Image> findAllByAlbumTitle_Id(Long id);
}
