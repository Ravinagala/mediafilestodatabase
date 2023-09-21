package com.example.mediafilestodatabase.repos;

import com.example.mediafilestodatabase.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageDataRepo extends JpaRepository<ImageData,Integer> {

    Optional<ImageData> findByName(String fileName);
}
