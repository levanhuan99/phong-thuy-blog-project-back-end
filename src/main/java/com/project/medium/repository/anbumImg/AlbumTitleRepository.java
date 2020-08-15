package com.project.medium.repository.anbumImg;

import com.project.medium.model.albumImg.AlbumTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumTitleRepository extends JpaRepository<AlbumTitle, Long> {
}
