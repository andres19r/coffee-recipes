package com.example.coffee.recipes.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

public record CoffeeRequestDto(
        @NotBlank(message = "Coffee name cannot be empty")
        String name,
        String farm,
        @NotBlank(message = "Coffee variety cannot be empty")
        String variety,
        @Pattern(regexp = "LIGHT|MEDIUM|DARK",
                message = "Invalid coffee roast level provided. Pick one between LIGHT, MEDIUM or DARK")
        String roast,
        @NotBlank(message = "Coffee process cannot be empty")
        String process,
        @PastOrPresent(message = "Roast date must be from past or present")
        LocalDate roastDate,
        LocalDate buyDate,
        String description
) {
}
