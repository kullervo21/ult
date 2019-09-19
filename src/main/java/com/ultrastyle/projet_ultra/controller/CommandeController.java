package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.dao.CommandeDao;
import com.ultrastyle.projet_ultra.model.Commande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CommandeController {

    private CommandeDao commandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @GetMapping({"listCommande"})
    public List<Commande> getListCommande(){
        return commandeDao.findAll();
    }
}
