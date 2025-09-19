package com.kasparas.recipeapi.controller;

import com.kasparas.recipeapi.dto.*;
import com.kasparas.recipeapi.service.RecipeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private final RecipeService service;
    public RecipeController(RecipeService service) { this.service = service; }

    @GetMapping public List<RecipeResponse> getAll() { return service.getAll(); }

    @GetMapping("/{id}") public RecipeResponse getById(@PathVariable Long id) { return service.getById(id); }

    @GetMapping("/search")
    public List<RecipeResponse> search(@RequestParam String ingredient) {
        return service.searchByIngredient(ingredient);
    }

    @PostMapping public RecipeResponse create(@RequestBody @Valid RecipeRequest req) { return service.create(req); }

    @PutMapping("/{id}") public RecipeResponse update(@PathVariable Long id, @RequestBody @Valid RecipeRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { service.delete(id); }
}