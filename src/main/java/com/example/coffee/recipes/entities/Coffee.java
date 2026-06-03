package com.example.coffee.recipes.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coffee", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Recipe> recipes;

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        recipe.setCoffee(this);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
    }
}

