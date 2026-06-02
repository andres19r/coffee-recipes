package com.example.coffee.recipes.dtos;

import com.example.coffee.recipes.entities.RoastLevel;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

public record CoffeeRequestDto(
        @NotBlank(message = "Coffee name cannot be empty")
        String name,
        String farm,
        @NotBlank(message = "Coffee variety cannot be empty")
        String variety,
        @NotBlank(message = "Coffee roast level cannot be empty")
        RoastLevel roast,
        @NotBlank(message = "Coffee process cannot be empty")
        String process,
        @PastOrPresent(message = "Roast date must be from past or present")
        LocalDate roastDate,
        LocalDate buyDate,
        String description
) {
}
