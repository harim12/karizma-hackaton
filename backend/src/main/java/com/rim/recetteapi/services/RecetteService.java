package com.rim.recetteapi.services;


import com.rim.recetteapi.entities.Recette;
import com.rim.recetteapi.repositories.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;

    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    public Optional<Recette> getRecetteById(Long id) {
        return recetteRepository.findById(id);
    }

    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    public Recette updateRecette(Long id, Recette updatedRecette) {
        if (recetteRepository.existsById(id)) {
            updatedRecette.setId(id);
            return recetteRepository.save(updatedRecette);
        } else {
            // Handle the case when the recette with the given id doesn't exist
            return null;
        }
    }

    public void deleteRecette(Long id) {
        recetteRepository.deleteById(id);
    }
}