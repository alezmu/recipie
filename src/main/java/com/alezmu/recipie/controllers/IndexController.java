package com.alezmu.recipie.controllers;


import com.alezmu.recipie.domain.Category;
import com.alezmu.recipie.domain.UnitOfMeasure;
import com.alezmu.recipie.repositories.CategoryRepository;
import com.alezmu.recipie.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("Uom id is: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
