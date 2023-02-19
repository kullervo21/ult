package com.ultrastyle.projet_ultra.repository;

import com.ultrastyle.projet_ultra.model.Commande;
import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Integer> {

    List<Commande> findByClientAdresseMail(String adresseMail);
}
