package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Category;
import com.example.springsecurityapplication.models.OrderShapki;
import com.example.springsecurityapplication.models.Statuses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusesRepository extends JpaRepository<Statuses, Integer> {

    Statuses findByName(String name);

    Optional<Statuses> findById(int id);

}
