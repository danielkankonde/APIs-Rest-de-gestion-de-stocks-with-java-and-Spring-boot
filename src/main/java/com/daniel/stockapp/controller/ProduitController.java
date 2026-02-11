package com.daniel.stockapp.controller;

import com.daniel.stockapp.model.Produit;
import com.daniel.stockapp.service.ProduitService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Produit> creerProduit(@Valid @RequestBody Produit produit) {
        Produit produitCreated = produitService.creerProduit(produit);
        return new ResponseEntity<>(produitCreated, HttpStatus.CREATED);
    }

    // Get all products
    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return new ResponseEntity<>(produitService.getAllProduits(), HttpStatus.OK);
    }

    // Détail of product
    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(produit -> new ResponseEntity<>(produit, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Update a product
    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        Produit updatedProduit = produitService.updateProduit(id, produit);
        return new ResponseEntity<>(updatedProduit, HttpStatus.OK);
    }
}
