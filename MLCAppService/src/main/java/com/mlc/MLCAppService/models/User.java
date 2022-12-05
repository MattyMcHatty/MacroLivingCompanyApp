package com.mlc.MLCAppService.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private double protein;
    private double carbs;
    private double fat;
    private double fibre;
    private double calories;
    private List<Recipe> favouriteRecipes;
    private List<Recipe> mealPlan;

    public User() {
        this.protein = 0;
        this.carbs = 0;
        this.fat = 0;
        this.fibre = 0;
        this.calories = 0;
        this.favouriteRecipes = new ArrayList<>();
        this.mealPlan = new ArrayList<>();
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getFibre() {
        return fibre;
    }

    public void setFibre(double fibre) {
        this.fibre = fibre;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public List<Recipe> getFavouriteRecipes() {
        return favouriteRecipes;
    }

    public void setFavouriteRecipes(List<Recipe> favouriteRecipes) {
        this.favouriteRecipes = favouriteRecipes;
    }

    public List<Recipe> getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(List<Recipe> mealPlan) {
        this.mealPlan = mealPlan;
    }
}
