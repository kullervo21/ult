package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.ClientRepository;
import com.ultrastyle.projet_ultra.repository.ProduitRepository;
import com.ultrastyle.projet_ultra.model.Client;
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

    private final ClientRepository clientRepository;
    private ProduitRepository produitRepository;


    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping({"/listClient"})
    public List<Client> getListClient(){
        return clientRepository.findAll();
    }

//TODO : condition retourne tjs true, mettre try catch
    @PostMapping({"/addUser"})
    public ResponseEntity addUser(@RequestBody Client client){
        ResponseEntity response = new ResponseEntity(null);
        try {
            clientRepository.save(client);
            ResponseEntity.status(HttpStatus.CREATED).body("{\"message\":\"Utilisateur créé avec succès\"}");
        } catch (Exception e) {
            System.out.println("Problem during the persistence");
            ResponseEntity.status(HttpStatus.METHOD_FAILURE).body("{\"message\":\"Utilisateur n'est pas créé avec succès\"}");
            throw (e);
        } finally {
            System.out.println("Transaction end !");
        }
        return response;
    }

    @PostMapping({"/logUser"})
    public Client getClient(@RequestBody Client client) {
        Client clt = clientRepository.findById(client.getAdresse_mail()).orElse(null);
        if (clt!=null && clt.getPassword().equals(client.getPassword())){
            return clt;
        }
        return null;
    }
}
