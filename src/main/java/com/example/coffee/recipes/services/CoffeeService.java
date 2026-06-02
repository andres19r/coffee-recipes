package com.example.coffee.recipes.services;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
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
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee save(CoffeeRequestDto requestDto) {
        Coffee coffee = coffeeMapper.toEntity(requestDto);
        return coffeeRepository.save(coffee);
    }

    @Override
    public Coffee update(UUID id, CoffeeRequestDto requestDto) {
        Coffee coffee = this.findById(id);
        coffeeMapper.updateFromDto(requestDto, coffee);
        return coffeeRepository.save(coffee);
    }

    @Override
    public Coffee findById(UUID id) {
        return coffeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Coffee not found with uuid: " + id));
    }

    @Override
    public void deleteById(UUID id) {
        Coffee coffee = this.findById(id);
        coffeeRepository.delete(coffee);

    }
}
