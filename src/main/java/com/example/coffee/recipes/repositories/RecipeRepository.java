package com.example.coffee.recipes.repositories;

import com.example.coffee.recipes.entities.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
