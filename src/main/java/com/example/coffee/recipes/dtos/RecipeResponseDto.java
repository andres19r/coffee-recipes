package com.example.coffee.recipes.dtos;

import java.util.UUID;

public record RecipeResponseDto(
        UUID id,
        Integer ratio,
        Integer dose,
        Integer grindingClicks,
        String grinderType,
        Integer numOfPours,
        String method,
        String filterType,
        String description,
        Integer score
) {
}
