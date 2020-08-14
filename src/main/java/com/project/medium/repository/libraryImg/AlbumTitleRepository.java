package com.project.medium.repository.libraryImg;

import com.project.medium.model.libraryImg.AlbumTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumTitleRepository extends JpaRepository<AlbumTitle, Long> {
}
