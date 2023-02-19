package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.model.Client;
import com.ultrastyle.projet_ultra.repository.ClientRepository;
import com.ultrastyle.projet_ultra.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class ClientController {

    private final ClientService clientService;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientService clientService,
                            ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @PostMapping({"/addUser"})
    public ResponseEntity<?> addUser(@RequestBody Client client){
        try {
            Client savedClient = clientService.saveClient(client);
            return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la création du client : " + e.getMessage());
        } finally {
            System.out.println("Transaction end !");
        }
    }

    @GetMapping({"/listUser"})
    public List<Client> getUserList(){
        return clientRepository.findAll();
    }
}
