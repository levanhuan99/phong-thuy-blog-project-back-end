package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.Image;
import com.project.medium.repository.anbumImg.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image findById(Long id) {
       return imageRepository.findById(id).orElse(null);
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image remove(Long id) {
        Image image = imageRepository.findById(id).orElse(null);
        imageRepository.deleteById(id);
        return image;
    }

    @Override
    public Image createNewObject(Image model) {

        return imageRepository.save(model);
    }

    @Override
    public List<Image> findAllByAlbumTitle_Id(Long id) {
        return imageRepository.findAllByAlbumTitle_Id(id);
    }
}