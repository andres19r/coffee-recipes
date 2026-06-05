package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
import com.example.coffee.recipes.dtos.RecipeResponseDto;
import com.example.coffee.recipes.entities.Coffee;
import com.example.coffee.recipes.entities.Recipe;
import com.example.coffee.recipes.exceptions.ResourceNotFoundException;
import com.example.coffee.recipes.mappers.RecipeMapper;
import com.example.coffee.recipes.repositories.RecipeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeService implements IRecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final ICoffeeService coffeeService;

    @Override
    public List<RecipeResponseDto> findAll() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(recipeMapper::toResponseDto).toList();
    }

    @Override
    public RecipeResponseDto save(RecipeRequestDto requestDto) {
        Recipe recipe = recipeMapper.toEntity(requestDto);
        Coffee coffee = coffeeService.findCoffeeById(requestDto.coffeeId());
        coffee.addRecipe(recipe);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toResponseDto(savedRecipe);
    }

    @Override
    public RecipeResponseDto update(UUID id, RecipeRequestDto requestDto) {
        Recipe recipe = this.findRecipeById(id);
        UUID coffeeId = recipe.getCoffee().getId();
        if (requestDto.coffeeId() != coffeeId) {
            Coffee oldCoffee = coffeeService.findCoffeeById(coffeeId);
            oldCoffee.removeRecipe(recipe);
            Coffee newCoffee = coffeeService.findCoffeeById(requestDto.coffeeId());
            newCoffee.addRecipe(recipe);
        }
        recipeMapper.updateFromDto(requestDto, recipe);
        Recipe updatedRecipe = recipeRepository.save(recipe);
        return recipeMapper.toResponseDto(updatedRecipe);
    }

    @Override
    public RecipeResponseDto findById(UUID id) {
        Recipe recipe = findRecipeById(id);
        return recipeMapper.toResponseDto(recipe);
    }

    @Override
    public void deleteById(UUID id) {
        Recipe recipe = this.findRecipeById(id);
        recipeRepository.delete(recipe);
    }

    private Recipe findRecipeById(UUID id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with uuid: " + id));
    }
}
