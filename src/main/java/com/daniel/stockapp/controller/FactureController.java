package com.daniel.stockapp.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.stockapp.DTO.FactureRequestDTO;
import com.daniel.stockapp.model.Facture;
import com.daniel.stockapp.service.FactureService;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    private final FactureService factureService;

    public FactureController(FactureService factureService) {
        this.factureService = factureService;
    }

    @PostMapping
    public ResponseEntity<Facture> creerFacture(@RequestBody FactureRequestDTO request) {
        return ResponseEntity.ok(factureService.creerFacture(request));
    }

}
