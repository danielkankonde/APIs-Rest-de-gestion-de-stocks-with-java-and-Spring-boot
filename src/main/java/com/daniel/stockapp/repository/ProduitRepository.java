package com.daniel.stockapp.repository;

import com.daniel.stockapp.model.Produit;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	List<Produit> findByCategorieId(Long categorieId);
}
