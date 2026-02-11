package com.daniel.stockapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @Min(value = 0, message = "Le prix doit être positif")
    private double prix;

    @NotNull(message = "La description est obligatoire")
    private String description;

    @Min(value = 0, message = "La quantité doit être positive")
    private int quantite;

    // Constructeurs
    public Produit() {}

    public Produit(String nom, double prix, int quantite, String description) {
        this.nom = nom;
        this.prix = prix;
        this.description = description;
        this.quantite = quantite;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
