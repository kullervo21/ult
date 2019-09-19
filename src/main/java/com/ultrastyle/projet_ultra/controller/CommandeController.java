package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.dao.CommandeDao;
import com.ultrastyle.projet_ultra.dao.LigneCommandeDao;
import com.ultrastyle.projet_ultra.model.Commande;
import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class CommandeController {

    private CommandeDao commandeDao;
    private LigneCommandeDao ligneCommandeDao;

    @Autowired
    public CommandeController(CommandeDao commandeDao, LigneCommandeDao ligneCommandeDao) {
        this.commandeDao = commandeDao;
        this.ligneCommandeDao = ligneCommandeDao;
    }

    @GetMapping({"listCommande"})
    public List<Commande> getListCommande(){
        return commandeDao.findAll();
    }

    @PostMapping({"/ajoutPanier"})
    public void ajoutPanier(@RequestBody Commande commande ){
        commandeDao.save(commande);
        commande.setDateCommande(LocalDate.now());
        for (LigneCommande ligneCommande : commande.getLigneCommandeList()) {
            ligneCommande.setCommande(commande);
        }
        ligneCommandeDao.saveAll(commande.getLigneCommandeList());
    }
}
