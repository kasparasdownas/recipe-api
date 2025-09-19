package com.kasparas.recipeapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) private String name;
    private String quantity; // e.g. "200g", "1 tbsp"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    // getters/setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getQuantity() { return quantity; }
    public Recipe getRecipe() { return recipe; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
    public void setRecipe(Recipe recipe) { this.recipe = recipe; }
}