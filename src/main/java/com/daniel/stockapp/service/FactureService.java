package com.daniel.stockapp.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daniel.stockapp.DTO.FactureRequestDTO;
import com.daniel.stockapp.DTO.LigneFactureRequestDTO;
import com.daniel.stockapp.model.Client;
import com.daniel.stockapp.model.Facture;
import com.daniel.stockapp.model.LigneFacture;
import com.daniel.stockapp.model.Produit;
import com.daniel.stockapp.repository.ClientRepository;
import com.daniel.stockapp.repository.FactureRepository;
import com.daniel.stockapp.repository.ProduitRepository;

import jakarta.transaction.Transactional;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    public FactureService(FactureRepository factureRepository,
                          ClientRepository clientRepository,
                          ProduitRepository produitRepository) {
        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
    }

    @Transactional
    public Facture creerFacture(FactureRequestDTO request) {

        Client client = clientRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        Facture facture = new Facture();
        facture.setClient(client);

        double total = 0;

        List<LigneFacture> lignesFacture = new java.util.ArrayList<>();

        for (LigneFactureRequestDTO ligneDTO : request.getLignes()) {

            Produit produit = produitRepository.findById(ligneDTO.getProduitId())
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé"));

            if (produit.getQuantite() < ligneDTO.getQuantite()) {
                throw new RuntimeException("Stock insuffisant");
            }

            // Mise à jour stock
            produit.setQuantite(produit.getQuantite() - ligneDTO.getQuantite());
            produitRepository.save(produit);

            // Création vraie entité LigneFacture
            LigneFacture ligne = new LigneFacture();
            ligne.setProduit(produit);
            ligne.setQuantite(ligneDTO.getQuantite());
            ligne.setPrixUnitaire(produit.getPrix());
            ligne.setFacture(facture);

            ligne.calculerSousTotal();

            total += ligne.getSousTotal();

            lignesFacture.add(ligne);
        }

        facture.setLignes(lignesFacture);
        facture.setTotal(total);

        return factureRepository.save(facture);
    }

}
