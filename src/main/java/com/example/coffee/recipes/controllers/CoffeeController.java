package com.example.coffee.recipes.controllers;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.dtos.CoffeeResponseDto;
import com.example.coffee.recipes.services.ICoffeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/coffees")
@RequiredArgsConstructor
public class CoffeeController {
    private final ICoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<List<CoffeeResponseDto>> getAllCoffees() {
        List<CoffeeResponseDto> coffees = coffeeService.findAll();
        return ResponseEntity.ok(coffees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoffeeResponseDto> getCoffeeById(@PathVariable UUID id) {
        CoffeeResponseDto coffee = coffeeService.findById(id);
        return ResponseEntity.ok(coffee);
    }

    @PostMapping
    public ResponseEntity<CoffeeResponseDto> saveCoffee(@Valid @RequestBody CoffeeRequestDto requestDto) {
        CoffeeResponseDto newCoffee = coffeeService.save(requestDto);
        return new ResponseEntity<>(newCoffee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoffeeResponseDto> updateCoffee(@PathVariable UUID id,
                                                          @Valid @RequestBody CoffeeRequestDto requestDto) {
        CoffeeResponseDto updatedCoffee = coffeeService.update(id, requestDto);
        return ResponseEntity.ok(updatedCoffee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable UUID id) {
        coffeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
