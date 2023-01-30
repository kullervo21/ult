package com.ultrastyle.projet_ultra.repository;

import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
