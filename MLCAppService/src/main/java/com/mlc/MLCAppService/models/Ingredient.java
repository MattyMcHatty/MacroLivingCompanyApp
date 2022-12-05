package com.mlc.MLCAppService.models;

public class Ingredient {
    private String name;

    // protein, carbs, fat, fibre are per 100 grams.
    private double protein;
    private double carbs;
    private double fat;
    private double fibre;
    private boolean isSelected;
    private boolean isVegan;
    private boolean isVegetarian;

    public Ingredient(String name, double protein, double carbs, double fat, double fibre, boolean isVegan, boolean isVegetarian) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.fibre = fibre;
        this.isSelected = false;
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public double calculateProteinCalories() {
        return this.protein * 4;
    }

    public double calculateCarbsCalories() {
        return this.carbs * 4;
    }

    public double calculateFatCalories() {
        return this.fat * 9;
    }

    public double calculateFibreCalories() {
        return this.fibre * 2;
    }

    public double calculateTotalCalories() {
        return calculateProteinCalories() + calculateCarbsCalories() + calculateFatCalories() +calculateFibreCalories();
    }

    public void updateIsSelected() {
        if(isSelected){
            this.isSelected = false;
        } else {
            this.isSelected = true;
        }
    }
}
