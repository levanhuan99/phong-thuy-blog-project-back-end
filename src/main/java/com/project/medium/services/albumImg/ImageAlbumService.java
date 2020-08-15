package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.ImageAlbum;
import com.project.medium.services.GenericService;

import java.util.List;

public interface ImageAlbumService extends GenericService<ImageAlbum> {
    List<ImageAlbum> saveList(List<ImageAlbum> imageAlbums);
}
