package com.ultrastyle.projet_ultra.dao;

import com.ultrastyle.projet_ultra.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, String> {

    @Query("SELECT c FROM Client c WHERE c.adresse_mail = ?1 and c.password = ?2")
    Client findClientByIdPasswd(String adresse_mail, String password);

}
