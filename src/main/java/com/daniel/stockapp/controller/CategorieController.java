package com.daniel.stockapp.controller;

import com.daniel.stockapp.model.Categorie;
import com.daniel.stockapp.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieController {

    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @PostMapping
    public ResponseEntity<Categorie> creerCategorie(@Valid @RequestBody Categorie categorie) {
        return ResponseEntity.ok(categorieService.creerCategorie(categorie));
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        return ResponseEntity.ok(categorieService.getAllCategories());
    }
}
