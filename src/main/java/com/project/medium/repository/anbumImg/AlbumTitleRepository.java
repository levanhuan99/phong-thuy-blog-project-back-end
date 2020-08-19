package com.project.medium.repository.anbumImg;

import com.project.medium.model.albumImg.AlbumTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumTitleRepository extends JpaRepository<AlbumTitle, Long> {
    List<AlbumTitle> findAllByAccount_Id(Long id);
}
