package com.mlc.MLCAppService.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredientTest {

    Ingredient bacon;

    @BeforeEach()
    public void before(){
        bacon = new Ingredient("Bacon",37, 0,41,0,false,false);
    }

    @Test
    public void canCalculateProteinCalories(){
        assertEquals(148, bacon.calculateProtein());

    }

}