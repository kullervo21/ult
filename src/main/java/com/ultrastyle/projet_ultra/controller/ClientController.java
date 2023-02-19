package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.model.Client;
import com.ultrastyle.projet_ultra.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class ClientController {

    /*private final ClientRepository clientRepository;
    private ProduitRepository produitRepository;*/
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    /* @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping({"/listClient"})
    public List<Client> getListClient(){
        return clientRepository.findAll();
    }
*/

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

    /*
    @PostMapping({"/logUser"})
    public Client getClient(@RequestBody Client client) {
        Client clt = clientRepository.findById(client.getAdresseMail()).orElse(null);
        if (clt!=null && clt.getPassword().equals(client.getPassword())){
            return clt;
        }
        return null;
    }
    */

}
