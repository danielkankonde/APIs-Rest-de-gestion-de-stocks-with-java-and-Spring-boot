package com.daniel.stockapp.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private double total;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "facture", cascade = CascadeType.ALL)
    private List<LigneFacture> lignes;

    public Facture() {
        this.date = LocalDate.now();
    }

    public Long getId() { return id; }

    public LocalDate getDate() { return date; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    public List<LigneFacture> getLignes() { return lignes; }

    public void setLignes(List<LigneFacture> lignes) { this.lignes = lignes; }
}
