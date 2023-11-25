package com.rim.recetteapi.controllers;

import com.rim.recetteapi.entities.Recette;
import com.rim.recetteapi.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    @GetMapping("/all")
    public String getAllRecettes() {
        //  List<Recette> recettes = recetteService.getAllRecettes();
        //return new ResponseEntity<>(recettes, HttpStatus.OK);
        return "all recetees";
    }


    @PostMapping("/add")
    public ResponseEntity<Recette> createRecette(@RequestBody Recette recette) {
        Recette createdRecette = recetteService.createRecette(recette);
        return new ResponseEntity<>(createdRecette, HttpStatus.CREATED);
    }
}
