package com.daniel.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.stockapp.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long>{
  
}
