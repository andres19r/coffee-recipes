package com.example.coffee.recipes.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    private String farm;

    @Column(nullable = false)
    private String variety;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoastLevel roast;

    @Column(nullable = false)
    private String process;

    private LocalDate roastDate;

    private LocalDate buyDate;

    private String description;
}

