package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitDao extends JpaRepository<Produit, Integer> {
}
