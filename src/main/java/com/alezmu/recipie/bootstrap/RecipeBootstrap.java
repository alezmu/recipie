package com.alezmu.recipie.bootstrap;

import com.alezmu.recipie.domain.*;
import com.alezmu.recipie.repositories.CategoryRepository;
import com.alezmu.recipie.repositories.RecipeRepository;
import com.alezmu.recipie.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);
        //get UOMS
        Optional<UnitOfMeasure> eachUOMOptional = unitOfMeasureRepository.findByDescription("Each");
        if(!eachUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tablespoonUOMOptional = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tablespoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> teaspoonUOMOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaspoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> dashUOMOptional = unitOfMeasureRepository.findByDescription("Dash");
        if(!dashUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> pintUOMOptional = unitOfMeasureRepository.findByDescription("Pint");
        if(!pintUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> cupsUOMOptional = unitOfMeasureRepository.findByDescription("Cup");
        if(!teaspoonUOMOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        //get UOMS
        UnitOfMeasure eachUom = eachUOMOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUOMOptional.get();
        UnitOfMeasure teaspoonUom = teaspoonUOMOptional.get();
        UnitOfMeasure dashUom = dashUOMOptional.get();
        UnitOfMeasure pintUom = pintUOMOptional.get();
        UnitOfMeasure cupsUom = cupsUOMOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> italianCategoryOptional = categoryRepository.findByDescription("Italian");
        if(!italianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }
        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Optional<Category> fastFoodCategoryOptional = categoryRepository.findByDescription("Fast Food");
        if(!fastFoodCategoryOptional.isPresent()){
            throw new RuntimeException("Expected Category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        //Guacamole

        Recipe guacRecie = new Recipe();
        guacRecie.setDescription("Perfect Guacamole");
        guacRecie.setPrepTime(10);
        guacRecie.setCookTime(0);
        guacRecie.setDifficulty(Difficulty.EASY);
        guacRecie.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl."+
                "\n"+
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)"+
                "\n"+
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown."+
                "\n"+
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness."+
                "\n"+
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste."+
                "\n"+
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving."+
                "\n"+
                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve."
                );

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Simple Guacamole: The simplest version of guacamole is just mashed avocados with salt. Don’t let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "Quick guacamole: For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Don’t have enough avocados? To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.");
        guacRecie.setNotes(guacNotes);
        guacRecie.getIngredients().add(new Ingredient("ripe avocado", new BigDecimal(2), eachUom));
        guacRecie.getIngredients().add(new Ingredient("Kosher salt", new BigDecimal(.5), teaspoonUom));
        guacRecie.getIngredients().add(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoonUom));
        guacRecie.getIngredients().add(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoonUom));
        guacRecie.getIngredients().add(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), eachUom));
        guacRecie.getIngredients().add(new Ingredient("cilantro", new BigDecimal(2), tablespoonUom));
        guacRecie.getIngredients().add(new Ingredient("freshly grated black pepper", new BigDecimal(1), dashUom));
        guacRecie.getIngredients().add(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(.5), eachUom));

        guacRecie.getCategories().add(americanCategory);
        guacRecie.getCategories().add(mexicanCategory);

        recipes.add(guacRecie);

        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setDescription("Spicy Grilled Chicken Tacos");
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setCookTime(9);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);
        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.");

        tacosRecipe.setNotes(tacoNotes);
        tacosRecipe.getIngredients().add(new Ingredient("ancho chili powder", new BigDecimal(2), tablespoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("dried oregano", new BigDecimal(1), teaspoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(1), teaspoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(1), teaspoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("salt", new BigDecimal(.5), teaspoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("Colve of garlic, chopped", new BigDecimal(1), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("finely grated orange zest", new BigDecimal(1), tablespoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoonUom));
        tacosRecipe.getIngredients().add(new Ingredient("olive oil", new BigDecimal(2), tablespoonUom));
        tacosRecipe.getIngredients().add(new Ingredient(" skinless, boneless chicken thighs", new BigDecimal(5), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient(" small corn tortillas", new BigDecimal(8), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("packed baby arugula", new BigDecimal(3), cupsUom));
        tacosRecipe.getIngredients().add(new Ingredient("medium ripe avocados, sliced", new BigDecimal(2), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("radishes, thinly sliced", new BigDecimal(4), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("cherry tomatoes, halved", new BigDecimal(.5), pintUom));
        tacosRecipe.getIngredients().add(new Ingredient("red onion, thinly sliced", new BigDecimal(.25), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("Roughly chopped cilantro", new BigDecimal(1), eachUom));
        tacosRecipe.getIngredients().add(new Ingredient("sour cream thinned with 1/4 cup milk", new BigDecimal(.5), cupsUom));
        tacosRecipe.getIngredients().add(new Ingredient("lime, cut into wedges", new BigDecimal(1), eachUom));

        tacosRecipe.getCategories().add(americanCategory);
        tacosRecipe.getCategories().add(mexicanCategory);

        recipes.add(tacosRecipe);

        return recipes;
    }
}
