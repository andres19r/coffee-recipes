package com.example.coffee.recipes.dtos;

import java.util.UUID;

import jakarta.validation.constraints.*;

public record RecipeRequestDto(
        @NotNull(message = "Ratio cannot be null")
        @Min(value = 2, message = "Ratio should be between 2 and 20")
        @Max(value = 20, message = "Ratio should be between 2 and 20")
        Integer ratio,

        @NotNull(message = "Dose cannot be null")
        @Positive(message = "Dose must be a positive number")
        Integer dose,

        @NotNull(message = "Grinding clicks cannot be null")
        @Positive(message = "Grinding clicks must be a positive number")
        Integer grindingClicks,

        @NotBlank(message = "Grinder type cannot be empty")
        String grinderType,

        @NotNull(message = "Num of Pours cannot be null")
        @Min(value = 1, message = "# of pours should be between 1 and 10")
        @Max(value = 10, message = "# of pours should be between 1 and 10")
        Integer numOfPours,

        @NotBlank(message = "Method cannot be empty")
        String method,

        @NotBlank(message = "Filter type cannot be null")
        String filterType,

        String description,

        Integer score,
       
        @NotNull(message = "Coffee id cannot be null")
        UUID coffeeId
) {
}
