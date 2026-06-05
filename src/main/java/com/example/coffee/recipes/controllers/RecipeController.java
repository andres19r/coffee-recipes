package com.example.coffee.recipes.controllers;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
import com.example.coffee.recipes.dtos.RecipeResponseDto;
import com.example.coffee.recipes.services.IRecipeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
public class RecipeController {
    private final IRecipeService recipeService;

    @GetMapping
    public ResponseEntity<List<RecipeResponseDto>> getAllRecipes() {
        var recipes = recipeService.findAll();
        return ResponseEntity.ok(recipes);
    }

    @PostMapping
    public ResponseEntity<RecipeResponseDto> saveRecipe(@Valid @RequestBody RecipeRequestDto requestDto) {
        RecipeResponseDto newRecipe = recipeService.save(requestDto);
        return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> findRecipeById(@PathVariable UUID id) {
        RecipeResponseDto recipe = recipeService.findById(id);
        return ResponseEntity.ok(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeResponseDto> updateRecipe(@PathVariable UUID id,
                                                          @Valid @RequestBody RecipeRequestDto requestDto) {
        RecipeResponseDto recipe = recipeService.update(id, requestDto);
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable UUID id) {
        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
