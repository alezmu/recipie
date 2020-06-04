package com.alezmu.recipie.repositories;

import com.alezmu.recipie.domain.Recipe;
import org.springframework.data.repository.CrudRepository;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
