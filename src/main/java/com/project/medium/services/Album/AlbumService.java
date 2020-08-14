package com.project.medium.services.Album;

import com.project.medium.model.Album;
import com.project.medium.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    Iterable<Album> findAll();
    List<Album> findByAccountId(Long id);
    Album save(Album album);
    void remove(Long id);



}
