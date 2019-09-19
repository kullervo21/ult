package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeDao extends JpaRepository<LigneCommande, Integer> {
}
