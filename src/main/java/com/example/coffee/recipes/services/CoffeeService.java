package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.dtos.CoffeeResponseDto;
import com.example.coffee.recipes.entities.Coffee;
import com.example.coffee.recipes.exceptions.ResourceNotFoundException;
import com.example.coffee.recipes.mappers.CoffeeMapper;
import com.example.coffee.recipes.repositories.CoffeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoffeeService implements ICoffeeService {
    private final CoffeeRepository coffeeRepository;
    private final CoffeeMapper coffeeMapper;

    @Override
    public List<CoffeeResponseDto> findAll() {
        List<Coffee> coffees = coffeeRepository.findAll();
        return coffees.stream().map(coffeeMapper::toResponseDto).toList();
    }

    @Override
    public CoffeeResponseDto save(CoffeeRequestDto requestDto) {
        Coffee coffee = coffeeMapper.toEntity(requestDto);
        Coffee savedCoffee = coffeeRepository.save(coffee);
        return coffeeMapper.toResponseDto(savedCoffee);
    }

    @Override
    public CoffeeResponseDto update(UUID id, CoffeeRequestDto requestDto) {
        Coffee coffee = findCoffeeById(id);
        coffeeMapper.updateFromDto(requestDto, coffee);
        Coffee updatedCoffee = coffeeRepository.save(coffee);
        return coffeeMapper.toResponseDto(updatedCoffee);
    }

    @Override
    public CoffeeResponseDto findById(UUID id) {
        Coffee coffee = findCoffeeById(id);
        return coffeeMapper.toResponseDto(coffee);
    }

    @Override
    public void deleteById(UUID id) {
        Coffee coffee = findCoffeeById(id);
        coffeeRepository.delete(coffee);
    }

    public Coffee findCoffeeById(UUID id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coffee not found with uuid: " + id));
    }
}
