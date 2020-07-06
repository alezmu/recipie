package com.alezmu.recipie.services;

import com.alezmu.recipie.commands.RecipeCommand;
import com.alezmu.recipie.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
