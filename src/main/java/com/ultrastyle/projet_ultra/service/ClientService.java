package com.ultrastyle.projet_ultra.service;

import com.ultrastyle.projet_ultra.model.Client;

public interface ClientService {
    Client findByAdresseMail(String adresseMail);

    Client saveClient(Client client);
}
