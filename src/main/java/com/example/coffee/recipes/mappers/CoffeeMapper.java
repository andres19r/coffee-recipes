package com.example.coffee.recipes.mappers;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.dtos.CoffeeResponseDto;
import com.example.coffee.recipes.entities.Coffee;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    CoffeeRequestDto toRequestDto(Coffee coffee);

    @Mapping(target = "id", ignore = true)
    Coffee toEntity(CoffeeRequestDto requestDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "recipes", ignore = true)
    void updateFromDto(CoffeeRequestDto requestDto, @MappingTarget Coffee toUpdate);

    CoffeeResponseDto toResponseDto(Coffee coffee);
}
