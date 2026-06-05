package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.dtos.CoffeeResponseDto;
import com.example.coffee.recipes.entities.Coffee;

import java.util.List;
import java.util.UUID;

public interface ICoffeeService {
    List<CoffeeResponseDto> findAll();

    CoffeeResponseDto save(CoffeeRequestDto requestDto);

    CoffeeResponseDto update(UUID id, CoffeeRequestDto requestDto);

    CoffeeResponseDto findById(UUID id);

    void deleteById(UUID id);

    Coffee findCoffeeById(UUID id);
}
