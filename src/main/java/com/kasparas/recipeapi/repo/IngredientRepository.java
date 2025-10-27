package com.kasparas.recipeapi.repo;

import com.kasparas.recipeapi.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {}