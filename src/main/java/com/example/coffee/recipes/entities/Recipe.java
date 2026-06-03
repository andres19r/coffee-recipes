package com.example.coffee.recipes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private Integer ratio;

    @Column(nullable = false)
    private Integer dose;

    @Column(nullable = false)
    private Integer grindingClicks;

    @Column(nullable = false)
    private String grinderType;

    @Column(nullable = false)
    private Integer numOfPours;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String filterType;

    private String description;

    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Coffee coffee;
}
