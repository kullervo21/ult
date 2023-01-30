package com.ultrastyle.projet_ultra.repository;

import com.ultrastyle.projet_ultra.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {


}
