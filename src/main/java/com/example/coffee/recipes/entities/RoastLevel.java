package com.example.coffee.recipes.entities;

import lombok.Getter;

@Getter
public enum RoastLevel {
    LIGHT("Light Roast"),
    MEDIUM("Medium Roast"),
    DARK("Dark Roast");

    private final String level;

    RoastLevel(String level) {
        this.level = level;
    }
}
