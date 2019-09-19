package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, String> {


}
