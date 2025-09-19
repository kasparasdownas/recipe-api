package com.kasparas.recipeapi.dto;

public class IngredientResponse {
    private Long id;
    private String name;
    private String quantity;

    public IngredientResponse() {}
    public IngredientResponse(Long id, String name, String quantity) {
        this.id = id; this.name = name; this.quantity = quantity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getQuantity() { return quantity; }
    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setQuantity(String quantity) { this.quantity = quantity; }
}