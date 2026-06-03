package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.entities.Coffee;

import java.util.List;
import java.util.UUID;

public interface ICoffeeService {
    List<Coffee> findAll();

    Coffee save(CoffeeRequestDto requestDto);

    Coffee update(UUID id, CoffeeRequestDto requestDto);

    Coffee findById(UUID id);

    void deleteById(UUID id);
}
