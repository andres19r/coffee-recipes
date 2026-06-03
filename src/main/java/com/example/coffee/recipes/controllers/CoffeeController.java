package com.example.coffee.recipes.controllers;

import com.example.coffee.recipes.dtos.CoffeeRequestDto;
import com.example.coffee.recipes.entities.Coffee;
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
    public ResponseEntity<List<Coffee>> getAllCoffees() {
        List<Coffee> coffees = coffeeService.findAll();
        return ResponseEntity.ok(coffees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable UUID id) {
        Coffee coffee = coffeeService.findById(id);
        return ResponseEntity.ok(coffee);
    }

    @PostMapping
    public ResponseEntity<Coffee> saveCoffee(@Valid @RequestBody CoffeeRequestDto requestDto) {
        Coffee newCoffee = coffeeService.save(requestDto);
        return new ResponseEntity<>(newCoffee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable UUID id, @Valid @RequestBody CoffeeRequestDto requestDto) {
        Coffee updatedCoffee = coffeeService.update(id, requestDto);
        return ResponseEntity.ok(updatedCoffee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoffee(@PathVariable UUID id) {
        coffeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
