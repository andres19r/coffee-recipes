package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
import com.example.coffee.recipes.dtos.RecipeResponseDto;

import java.util.List;
import java.util.UUID;

public interface IRecipeService {
    List<RecipeResponseDto> findAll();

    RecipeResponseDto save(RecipeRequestDto requestDto);

    RecipeResponseDto update(UUID id, RecipeRequestDto requestDto);

    RecipeResponseDto findById(UUID id);

    void deleteById(UUID id);

}
