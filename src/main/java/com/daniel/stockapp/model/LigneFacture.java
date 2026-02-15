package com.daniel.stockapp.model;

import jakarta.persistence.*;

@Entity
public class LigneFacture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;

    private double prixUnitaire;

    private double sousTotal;

    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "facture_id")
    private Facture facture;

    public LigneFacture() {}

    public void calculerSousTotal() {
        this.sousTotal = this.quantite * this.prixUnitaire;
    }

    public double getSousTotal() { return sousTotal; }

    public int getQuantite() { return quantite; }

    public void setQuantite(int quantite) { this.quantite = quantite; }

    public double getPrixUnitaire() { return prixUnitaire; }

    public void setPrixUnitaire(double prixUnitaire) { this.prixUnitaire = prixUnitaire; }

    public Produit getProduit() { return produit; }

    public void setProduit(Produit produit) { this.produit = produit; }

    public void setFacture(Facture facture) { this.facture = facture; }
}
