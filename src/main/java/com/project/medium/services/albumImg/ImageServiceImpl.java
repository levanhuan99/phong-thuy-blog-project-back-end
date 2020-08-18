package com.project.medium.services.albumImg;

import com.project.medium.repository.anbumImg.ImageRepository;
import javafx.scene.image.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
  public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image findById(Long id) {
        return Optional<imageRepository.findById(id);
    }

    @Override
    public List<Image> getAll() {
        return null;
    }

    @Override
    public Image remove(Long id) {
        return null;
    }

    @Override
    public Image createNewObject(Image model) {
        return null;
    }
}