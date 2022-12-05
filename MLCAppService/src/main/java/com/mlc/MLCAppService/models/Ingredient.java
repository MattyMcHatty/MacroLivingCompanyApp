package com.mlc.MLCAppService.models;

import javax.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    // protein, carbs, fat, fibre are per 100 grams.
    @Column(name = "protein")
    private double protein;
    @Column(name = "carbs")
    private double carbs;
    @Column(name = "fat")
    private double fat;
    @Column(name = "fibre")
    private double fibre;
    @Column(name = "isSelected")
    private boolean isSelected;
    @Column(name = "isVegan")
    private boolean isVegan;
    @Column(name = "isVegetarian")
    private boolean isVegetarian;
    //Many ingredients can go into one recipe but dont need to go into all recipes
    @ManyToOne
    @JoinColumn(name="recipe_id", nullable=false)
    private Recipe recipe;

    public Ingredient(String name, double protein, double carbs, double fat, double fibre, boolean isVegan, boolean isVegetarian) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.fibre = fibre;
        this.isSelected = false;
        this.isVegan = isVegan;
        this.isVegetarian = isVegetarian;
        this.recipe = new Recipe();
    }

    private Ingredient(){}

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
