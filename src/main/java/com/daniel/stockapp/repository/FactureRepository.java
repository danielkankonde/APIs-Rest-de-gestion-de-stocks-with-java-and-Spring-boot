package com.daniel.stockapp.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.daniel.stockapp.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
