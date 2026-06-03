package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
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
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe save(RecipeRequestDto requestDto) {
        Recipe recipe = recipeMapper.toEntity(requestDto);
        Coffee coffee = coffeeService.findById(requestDto.coffeeId());
        coffee.addRecipe(recipe);
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe update(UUID id, RecipeRequestDto requestDto) {
        Recipe recipe = this.findById(id);
        UUID coffeeId = recipe.getCoffee().getId();
        if (requestDto.coffeeId() != coffeeId) {
            Coffee oldCoffee = coffeeService.findById(coffeeId);
            oldCoffee.removeRecipe(recipe);
            Coffee newCoffee = coffeeService.findById(requestDto.coffeeId());
            newCoffee.addRecipe(recipe);
        }
        recipeMapper.updateFromDto(requestDto, recipe);
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe findById(UUID id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recipe not found with uuid: " + id));
    }

    @Override
    public void deleteById(UUID id) {
        Recipe recipe = this.findById(id);
        recipeRepository.delete(recipe);
    }
}
