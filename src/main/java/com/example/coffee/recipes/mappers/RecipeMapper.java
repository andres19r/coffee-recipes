package com.example.coffee.recipes.mappers;

import com.example.coffee.recipes.dtos.RecipeRequestDto;
import com.example.coffee.recipes.dtos.RecipeResponseDto;
import com.example.coffee.recipes.entities.Recipe;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeRequestDto toRequestDto(Recipe recipe);

    @Mapping(target = "id", ignore = true)
    Recipe toEntity(RecipeRequestDto requestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "coffee", ignore = true)
    void updateFromDto(RecipeRequestDto requestDto, @MappingTarget Recipe toUpdate);

    RecipeResponseDto toResponseDto(Recipe recipe);
}
