package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.AlbumTitle;
import com.project.medium.repository.anbumImg.AlbumTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
  public class AlbumTitleServiceImpl implements AlbumTitleService{
   @Autowired
   private AlbumTitleRepository albumTitleRepository;
    @Override
    public AlbumTitle findById(Long id) {
       return albumTitleRepository.findById(id).orElse(null);
    }

    @Override
    public List<AlbumTitle> getAll() {
        return albumTitleRepository.findAll();
    }

    @Override
    public AlbumTitle remove(Long id) {
        albumTitleRepository.deleteById(id);
        return albumTitleRepository.findById(id).orElse(null);
    }

    @Override
    public AlbumTitle createNewObject(AlbumTitle model) {
        return albumTitleRepository.save(model);
    }
}