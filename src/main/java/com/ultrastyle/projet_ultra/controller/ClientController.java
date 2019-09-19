package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.dao.ClientDao;
import com.ultrastyle.projet_ultra.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    private ClientDao clientDao;


    @Autowired
    public ClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping({"/listClient"})
    public List<Client> getListClient(){
        return clientDao.findAll();
    }


    @PostMapping({"/addUser"})
    public ResponseEntity<String> addUser(@RequestBody Client client){
        if(clientDao.save(client)!=null){
            return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\":\"Utilisateur créé avec succès\"}");
        }else {
            return ResponseEntity.status(HttpStatus.METHOD_FAILURE).body("{\"message\":\"Utilisateur n'est pas créé avec succès\"}");
        }
    }

    @PostMapping({"/logUser"})
    public Client getClient(@RequestBody Client client) {
        //return clientDao.findClientByIdPasswd(client.getAdresse_mail(), client.getPassword());
        Client clt = clientDao.findById(client.getAdresse_mail()).orElse(null);
        if (clt!=null && clt.getPassword().equals(client.getPassword())){
            return clt;
        }
        return null;
    }

}
