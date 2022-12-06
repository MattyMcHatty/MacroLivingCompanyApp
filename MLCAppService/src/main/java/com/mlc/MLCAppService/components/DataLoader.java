package com.mlc.MLCAppService.components;

import com.mlc.MLCAppService.models.Ingredient;
import com.mlc.MLCAppService.models.Recipe;
import com.mlc.MLCAppService.models.Steps;
import com.mlc.MLCAppService.models.User;
import com.mlc.MLCAppService.repository.IngredientRepository;
import com.mlc.MLCAppService.repository.RecipeRepository;
import com.mlc.MLCAppService.repository.StepsRepository;
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
    @Autowired
    StepsRepository stepsRepository;

    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User();
        userRepository.save(user);

        Ingredient bacon = new Ingredient("Bacon",37, 0,41,0,false,false, "per 2 slices", 200.0);
        ingredientRepository.save(bacon);

        Ingredient apple = new Ingredient("Apple", 0, 13, 0 , 2, true, true , "per one apple", 75.0);
        ingredientRepository.save(apple);

        Ingredient cashews = new Ingredient("Cashews", 18, 27, 44, 3, true, true, "per 20", 125.0);
        ingredientRepository.save(cashews);

        Steps bacSaladSteps = new Steps();
        stepsRepository.save(bacSaladSteps);

        bacSaladSteps.setStep1("chop apple");
        stepsRepository.save(bacSaladSteps);

        Recipe bacSalad = new Recipe("BAC Salad", bacSaladSteps);
        recipeRepository.save(bacSalad);


//        bacSalad.addIngredient(bacon, 20);
//        bacSalad.addIngredient(apple, 50);
//        bacSalad.addIngredient(cashews, 10);
//        recipeRepository.save(bacSalad);


    }
}
