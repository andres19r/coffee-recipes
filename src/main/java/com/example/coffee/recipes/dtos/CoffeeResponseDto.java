package com.example.coffee.recipes.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record CoffeeResponseDto(
        UUID id,
        String name,
        String farm,
        String variety,
        String roast,
        String process,
        LocalDate roastDate,
        LocalDate buyDate,
        String description,
        List<RecipeResponseDto> recipes
) {
}
