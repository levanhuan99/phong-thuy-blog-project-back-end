package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.ImageAlbum;
import com.project.medium.repository.anbumImg.ImageAlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class ImageAlbumServiceImpl implements ImageAlbumService {
    @Autowired
    private ImageAlbumRepository imageAlbumRepository;
    @Override
    public ImageAlbum findById(Long id) {
       return imageAlbumRepository.findById(id).orElse(null);
    }

    @Override
    public List<ImageAlbum> getAll() {
       return imageAlbumRepository.findAll();
    }

    @Override
    public ImageAlbum remove(Long id) {
        imageAlbumRepository.deleteById(id);
        return imageAlbumRepository.findById(id).orElse(null);
    }

    @Override
    public ImageAlbum createNewObject(ImageAlbum model) {
       return  imageAlbumRepository.save(model);
    }

    @Override
    public List<ImageAlbum> saveList(List<ImageAlbum> imageAlbums) {
        return imageAlbumRepository.saveAll(imageAlbums);
    }
}