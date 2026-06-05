package com.example.coffee.recipes.dtos;

import java.util.List;
import java.util.UUID;

public record RecipeResponseDto(
        UUID id,
        Integer ratio,
        Integer dose,
        Double totalCup,
        Integer grindingClicks,
        String grinderType,
        Integer numOfPours,
        List<String> pours,
        String method,
        String filterType,
        String description,
        Integer score
) {
}
