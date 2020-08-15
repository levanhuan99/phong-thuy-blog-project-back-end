package com.project.medium.repository.anbumImg;

import com.project.medium.model.albumImg.ImageAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageAlbumRepository extends JpaRepository<ImageAlbum, Long> {
}
