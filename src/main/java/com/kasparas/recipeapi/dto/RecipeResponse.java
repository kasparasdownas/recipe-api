package com.kasparas.recipeapi.dto;

import java.time.LocalDateTime;
import java.util.List;

public class RecipeResponse {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private List<IngredientResponse> ingredients;

    public RecipeResponse() {}

    public RecipeResponse(Long id, String title, String description,
                          LocalDateTime createdAt, List<IngredientResponse> ingredients) {
        this.id = id; this.title = title; this.description = description;
        this.createdAt = createdAt; this.ingredients = ingredients;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public List<IngredientResponse> getIngredients() { return ingredients; }
    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public void setIngredients(List<IngredientResponse> ingredients) { this.ingredients = ingredients; }
}