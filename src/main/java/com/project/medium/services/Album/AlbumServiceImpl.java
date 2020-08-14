package com.project.medium.services.Album;

import com.project.medium.model.Album;
import com.project.medium.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;


    @Override
    public Iterable<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> findByAccountId(Long id) {
        return albumRepository.findAlbumsByAccount_Id(id);
    }


    @Override
    public Album save(Album album) {
        return albumRepository.save(album);
    }

    @Override
    public void remove(Long id) { albumRepository.deleteById(id);
    }
}
