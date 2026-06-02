package com.example.coffee.recipes.repositories;

import com.example.coffee.recipes.entities.Coffee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CoffeeRepository extends JpaRepository<Coffee, UUID> {
    Optional<Coffee> findByName(String name);
}
