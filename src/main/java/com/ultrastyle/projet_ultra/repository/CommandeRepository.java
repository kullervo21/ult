package com.ultrastyle.projet_ultra.repository;

import com.ultrastyle.projet_ultra.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
