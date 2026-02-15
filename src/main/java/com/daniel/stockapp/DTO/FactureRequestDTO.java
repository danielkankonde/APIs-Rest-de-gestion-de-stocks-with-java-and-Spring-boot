package com.daniel.stockapp.DTO;
import java.util.List;

public class FactureRequestDTO {

    private Long clientId;
    private List<LigneFactureRequestDTO> lignes;

    // getters setters
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public List<LigneFactureRequestDTO> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneFactureRequestDTO> lignes) {
        this.lignes = lignes;
    }

}
