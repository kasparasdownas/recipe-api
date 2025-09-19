package com.kasparas.recipeapi.repo;

import com.kasparas.recipeapi.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("""
        select distinct r from Recipe r
        join r.ingredients i
        where lower(i.name) like lower(concat('%', :ingredient, '%'))
    """)
    List<Recipe> findByIngredientLike(String ingredient);
}