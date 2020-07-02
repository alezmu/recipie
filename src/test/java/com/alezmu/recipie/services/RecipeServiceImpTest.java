package com.alezmu.recipie.services;

import com.alezmu.recipie.domain.Recipe;
import com.alezmu.recipie.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class RecipeServiceImpTest {

    RecipeServiceImp recipeServiceImp;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeServiceImp = new RecipeServiceImp(recipeRepository);
    }

    @Test
    public void getRecipeByIdTest() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeServiceImp.findById(1L);

        assertNotNull( recipeReturned, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }

    @Test
    void getRecipes() {
        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);
        Set<Recipe> recipes = recipeServiceImp.getRecipes();
        assertEquals(recipes.size(), 1);
    }
}