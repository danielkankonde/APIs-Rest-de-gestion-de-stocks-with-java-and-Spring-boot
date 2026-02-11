package com.daniel.stockapp.model;

import jakarta.persistence.*;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    private double prix;

    private String description;

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
