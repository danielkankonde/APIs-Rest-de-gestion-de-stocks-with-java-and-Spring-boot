package com.daniel.stockapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.stockapp.model.LigneFacture;

public interface LigneFactureRepository extends JpaRepository<LigneFacture, Long> {
}
