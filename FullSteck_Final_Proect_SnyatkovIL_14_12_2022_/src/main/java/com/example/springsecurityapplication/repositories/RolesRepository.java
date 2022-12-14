package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles findByName(String name);

    Optional<Roles> findById(int id);

}
