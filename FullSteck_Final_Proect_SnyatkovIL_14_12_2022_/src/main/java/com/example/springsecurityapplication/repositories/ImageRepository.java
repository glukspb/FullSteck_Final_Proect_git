package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findById(int id);
}
