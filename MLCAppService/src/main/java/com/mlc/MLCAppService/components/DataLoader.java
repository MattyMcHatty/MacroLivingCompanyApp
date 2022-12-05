package com.mlc.MLCAppService.components;

import com.mlc.MLCAppService.models.Ingredient;
import com.mlc.MLCAppService.models.Recipe;
import com.mlc.MLCAppService.models.User;
import com.mlc.MLCAppService.repository.IngredientRepository;
import com.mlc.MLCAppService.repository.RecipeRepository;
import com.mlc.MLCAppService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    UserRepository userRepository;
    @Autowired
    IngredientRepository ingredientRepository;
    @Autowired
    RecipeRepository recipeRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Ingredient bacon = new Ingredient("Bacon",37, 0,41,0,false,false);
        ingredientRepository.save(bacon);

        Ingredient apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true );
        ingredientRepository.save(apple);

        Ingredient cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true);
        ingredientRepository.save(cashews);

        Recipe bacSalad = new Recipe("BAC Salad");
        recipeRepository.save(bacSalad);

//        bacSalad.addIngredient(bacon, 20);
//        bacSalad.addIngredient(apple, 50);
//        bacSalad.addIngredient(cashews, 10);
//        recipeRepository.save(bacSalad);

        User user = new User();
        userRepository.save(user);
    }
}
