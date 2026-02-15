package com.daniel.stockapp.DTO;
public class LigneFactureRequestDTO {

    private Long produitId;
    private int quantite;

    // getters setters
    public Long getProduitId() {
        return produitId;
    }

    public void setProduitId(Long produitId) {
        this.produitId = produitId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
