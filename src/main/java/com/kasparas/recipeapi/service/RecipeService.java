package com.kasparas.recipeapi.service;

import com.kasparas.recipeapi.dto.IngredientRequest;
import com.kasparas.recipeapi.dto.IngredientResponse;
import com.kasparas.recipeapi.dto.RecipeRequest;
import com.kasparas.recipeapi.dto.RecipeResponse;
import com.kasparas.recipeapi.entity.Ingredient;
import com.kasparas.recipeapi.entity.Recipe;
import com.kasparas.recipeapi.repo.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class RecipeService {

    private final RecipeRepository recipes;

    public RecipeService(RecipeRepository recipes) {
        this.recipes = recipes;
    }

    // ----- mapping helpers (explicit names, no ambiguity) -----
    private Ingredient toIngredientEntity(IngredientRequest r) {
        Ingredient i = new Ingredient();
        i.setName(r.getName());
        i.setQuantity(r.getQuantity());
        return i;
    }

    private Recipe toRecipeEntity(RecipeRequest req) {
        Recipe r = new Recipe();
        r.setTitle(req.getTitle());
        r.setDescription(req.getDescription());
        if (req.getIngredients() != null) {
            var ings = req.getIngredients().stream()
                    .map(this::toIngredientEntity)
                    .toList();
            r.setIngredients(ings);
        }
        return r;
    }

    private IngredientResponse toIngredientResponse(Ingredient i) {
        return new IngredientResponse(i.getId(), i.getName(), i.getQuantity());
    }

    private RecipeResponse toRecipeResponse(Recipe r) {
        var ings = r.getIngredients().stream().map(this::toIngredientResponse).toList();
        return new RecipeResponse(r.getId(), r.getTitle(), r.getDescription(), r.getCreatedAt(), ings);
    }

    // ----- API methods -----
    public List<RecipeResponse> getAll() {
        return recipes.findAll().stream().map(this::toRecipeResponse).toList();
    }

    public RecipeResponse getById(Long id) {
        var r = recipes.findById(id).orElseThrow(() -> new NoSuchElementException("Recipe " + id + " not found"));
        return toRecipeResponse(r);
    }

    public List<RecipeResponse> searchByIngredient(String ingredient) {
        return recipes.findByIngredientLike(ingredient).stream().map(this::toRecipeResponse).toList();
    }

    public RecipeResponse create(RecipeRequest req) {
        var r = toRecipeEntity(req);
        return toRecipeResponse(recipes.save(r));
    }

    public RecipeResponse update(Long id, RecipeRequest req) {
        var r = recipes.findById(id).orElseThrow(() -> new NoSuchElementException("Recipe " + id + " not found"));
        r.setTitle(req.getTitle());
        r.setDescription(req.getDescription());
        var ings = (req.getIngredients() == null) ? List.<Ingredient>of()
                : req.getIngredients().stream().map(this::toIngredientEntity).toList();
        r.setIngredients(ings);
        return toRecipeResponse(recipes.save(r));
    }

    public void delete(Long id) {
        if (!recipes.existsById(id)) throw new NoSuchElementException("Recipe " + id + " not found");
        recipes.deleteById(id);
    }
}