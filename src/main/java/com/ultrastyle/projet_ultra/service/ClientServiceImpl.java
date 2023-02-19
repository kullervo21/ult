package com.ultrastyle.projet_ultra.service;

import com.ultrastyle.projet_ultra.model.Client;
import com.ultrastyle.projet_ultra.model.Role;
import com.ultrastyle.projet_ultra.repository.ClientRepository;
import com.ultrastyle.projet_ultra.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired

    private ClientRepository clientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Client findByAdresseMail(String adresseMail) {
        return clientRepository.findByAdresseMail(adresseMail);
    }

    @Override
    public Client saveClient(Client client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        Role userRole = roleRepository.findByRole("USER");
        client.setRole(userRole);
        return clientRepository.save(client);
    }

}
