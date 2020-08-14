package com.project.medium.repository.libraryImg;

import com.project.medium.model.libraryImg.ImageLibrary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageLibraryRepository extends JpaRepository<ImageLibrary, Long> {
}
