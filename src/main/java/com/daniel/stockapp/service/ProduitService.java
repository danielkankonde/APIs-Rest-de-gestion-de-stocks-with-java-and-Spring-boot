package com.daniel.stockapp.service;

import com.daniel.stockapp.model.Produit;
import com.daniel.stockapp.repository.ProduitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    // Créer un produit
    public Produit creerProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    // Lister tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    // Trouver un produit par ID
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    // Supprimer un produit
    public void supprimerProduit(Long id) {
        produitRepository.deleteById(id);
    }
}
