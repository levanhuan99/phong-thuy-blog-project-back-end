package com.project.medium.repository;

import com.project.medium.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findAlbumsByAccount_Id(Long id);
}
