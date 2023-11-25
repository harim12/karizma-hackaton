package com.rim.recetteapi.repositories;


import com.rim.recetteapi.entities.Recette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetteRepository extends JpaRepository<Recette, Long> {
    // You can add custom query methods if needed
}