package com.alezmu.recipie.domain;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    Category category;


    @BeforeEach
    public void setUp(){
    category = new Category();
    }
    @Test
    void getId() {
        Long idValue = 4L;
        category.setId(4L);
        assertEquals(idValue, category.getId());
    }

    @Test
    void getDescription() {
        String desc= "just perfect";
        category.setDescription(desc);
        assertEquals(desc, category.getDescription());
    }

    @Test
    void getRecipes() {

    }
}