package com.mlc.MLCAppService.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recipe {
    private String name;
    private HashMap<Ingredient, Double> ingredients;
    private List<String> steps;
    private boolean favourite;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new HashMap<>();
        this.steps = new ArrayList<>();
        this.favourite = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Ingredient, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Double> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public void addIngredient(Ingredient ingredient, double weight) {
        ingredients.put(ingredient, weight);

    }

    public void addStep(String step) {
        this.steps.add(step);
    }

    public double calculateProtein() {
        double runningTotal = 0;
        for(Map.Entry<Ingredient, Double> set: ingredients.entrySet()){
            runningTotal += (set.getKey().getProtein() /100 * set.getValue());
        }
        return runningTotal;
    }

    public double calculateCarbs() {
        double runningTotal = 0;
        for(Map.Entry<Ingredient, Double> set: ingredients.entrySet()){
            runningTotal += (set.getKey().getCarbs() /100 * set.getValue());
        }
        return runningTotal;
    }

    public double calculateFat() {
        double runningTotal = 0;
        for(Map.Entry<Ingredient, Double> set: ingredients.entrySet()){
            runningTotal += (set.getKey().getFat() /100 * set.getValue());
        }
        return runningTotal;
    }

    public double calculateFibre() {
        double runningTotal = 0;
        for(Map.Entry<Ingredient, Double> set: ingredients.entrySet()){
            runningTotal += (set.getKey().getFibre() /100 * set.getValue());
        }
        return runningTotal;
    }

    public double calculateTotalCalories() {
        double runningTotal = 0;
        for(Map.Entry<Ingredient, Double> set: ingredients.entrySet()){
            runningTotal += (set.getKey().calculateTotalCalories() /100 * set.getValue());
        }
        return runningTotal;

    }

    public HashMap getMacros() {
        HashMap<String, Double> macros = new HashMap<>();
        macros.put("protein", calculateProtein());
        macros.put("carbs", calculateCarbs());
        macros.put("fat", calculateFat());
        macros.put("fibre", calculateFibre());
        macros.put("calories", calculateTotalCalories());

        return macros;
    }

    public void updateIsFavourite() {
        if(favourite){
            this.favourite = false;
        } else {
            this.favourite = true;
        }
    }
}
