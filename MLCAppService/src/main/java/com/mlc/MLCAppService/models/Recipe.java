package com.mlc.MLCAppService.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
//    @JsonBackReference
    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
//    private HashMap<Ingredient, Double> ingredients;
    @MapKey(name = "ingredient_id")
    private Map<Double, Ingredient> ingredients;

    @Column(name = "steps")
    private List<String> steps;
    @Column(name = "favourite")
    private boolean favourite;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Recipe(String name) {
        this.name = name;
        this.ingredients = new HashMap<>();
        this.steps = new ArrayList<>();
        this.favourite = false;
        this.user = new User();
    }

    public Recipe(){}

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
