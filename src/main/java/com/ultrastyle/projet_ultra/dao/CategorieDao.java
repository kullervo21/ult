package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Integer> {
}
