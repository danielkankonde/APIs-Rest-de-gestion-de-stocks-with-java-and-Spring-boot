package com.daniel.stockapp.repository;

import com.daniel.stockapp.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
