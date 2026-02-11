package com.daniel.stockapp.controller;

import com.daniel.stockapp.model.Produit;
import com.daniel.stockapp.service.ProduitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    // Injection of dependances
    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    // Create product
    @PostMapping
    public Produit creerProduit(@RequestBody Produit produit) {
        return produitService.creerProduit(produit);
    }

    // Get all products
    @GetMapping
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    // Détail of product
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public void supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
    }
}
