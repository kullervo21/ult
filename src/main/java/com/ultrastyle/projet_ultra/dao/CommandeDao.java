package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeDao extends JpaRepository<Commande, Integer> {
}
