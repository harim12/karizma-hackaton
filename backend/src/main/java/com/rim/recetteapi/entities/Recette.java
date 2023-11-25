package com.rim.recetteapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ElementCollection
    @CollectionTable(name = "etapes_preparation", joinColumns = @JoinColumn(name = "recette_id"))
    @Column(name = "etape")
    private List<String> etapesPreparation;

    private String dureePreparation;

    @Column(nullable = true)  // Make the photoOptionnelle field nullable
    private String photoOptionnelle;

    private String photo;

    @ManyToMany
    @JoinTable(
            name = "recette_ingredient",
            joinColumns = @JoinColumn(name = "recette_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private List<Ingrediant> ingrediants;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
