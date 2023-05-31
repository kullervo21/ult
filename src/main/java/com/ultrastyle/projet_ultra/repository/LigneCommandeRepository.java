package com.ultrastyle.projet_ultra.repository;

import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {
}
