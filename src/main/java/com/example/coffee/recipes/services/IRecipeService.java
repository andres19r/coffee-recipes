package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
import com.example.coffee.recipes.entities.Recipe;

import java.util.List;
import java.util.UUID;

public interface IRecipeService {
    List<Recipe> findAll();

    Recipe save(RecipeRequestDto requestDto);

    Recipe update(UUID id, RecipeRequestDto requestDto);

    Recipe findById(UUID id);

    void deleteById(UUID id);

}
