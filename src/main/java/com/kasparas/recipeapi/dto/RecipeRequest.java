package com.kasparas.recipeapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class RecipeRequest {
    @NotBlank
    private String title;
    private String description;
    @Valid
    private List<IngredientRequest> ingredients;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<IngredientRequest> getIngredients() { return ingredients; }
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setIngredients(List<IngredientRequest> ingredients) { this.ingredients = ingredients; }
}