package com.project.medium.services.albumImg;

import com.project.medium.model.albumImg.AlbumTitle;
import com.project.medium.services.GenericService;

import java.util.List;

public interface AlbumTitleService extends GenericService<AlbumTitle> {
    List<AlbumTitle> findAllByAccount_Id(Long id);

}
