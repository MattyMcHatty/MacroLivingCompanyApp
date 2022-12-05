package com.mlc.MLCAppService.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
}
