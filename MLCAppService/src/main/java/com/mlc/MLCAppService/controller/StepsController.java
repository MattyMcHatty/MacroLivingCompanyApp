package com.mlc.MLCAppService.controller;

import com.mlc.MLCAppService.models.Recipe;
import com.mlc.MLCAppService.models.Steps;
import com.mlc.MLCAppService.repository.RecipeRepository;
import com.mlc.MLCAppService.repository.StepsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class StepsController {
    @Autowired
    StepsRepository stepsRepository;

    @GetMapping(value="/steps")
    public ResponseEntity<List<Steps>> getAllSteps(){
        return new ResponseEntity<>(stepsRepository.findAll(), HttpStatus.OK);
    }
}



