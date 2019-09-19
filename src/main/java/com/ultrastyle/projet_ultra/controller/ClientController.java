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

    @PostMapping({"/logUser/{mail}/{password}"})
    public Client getClient(@PathVariable String mail, @PathVariable String password) {
        return clientDao.findClientByIdPasswd(mail, password);
    }

}
