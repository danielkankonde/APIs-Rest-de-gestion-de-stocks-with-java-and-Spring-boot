package com.daniel.stockapp.repository;

import com.daniel.stockapp.model.Produit;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

	// Méthode personnalisée pour trouver les produits par catégorie
	List<Produit> findByCategorieId(Long categorieId);

	// Méthode pour faire la pagination des produits
	Page<Produit> findAll(Pageable pageable);
}
