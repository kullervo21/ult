package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.CommandeRepository;
import com.ultrastyle.projet_ultra.repository.LigneCommandeRepository;
import com.ultrastyle.projet_ultra.model.Commande;
import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class CommandeController {

    private final CommandeRepository commandeRepository;
    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public CommandeController(CommandeRepository commandeRepository, LigneCommandeRepository ligneCommandeRepository) {
        this.commandeRepository = commandeRepository;
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @GetMapping({"/admin/listCommande"})
    public List<Commande> getListCommande(){
        return commandeRepository.findAll();
    }

    @GetMapping({"/client/{id}/listCommandes"})
    public List<Commande> getListCommandeOfUser(@PathVariable String id) {
        return commandeRepository.findByClientAdresseMail(id);
    }

    @PostMapping({"/ajoutPanier"})
    public void ajoutPanier(@RequestBody Commande commande ){
        commandeRepository.save(commande);
        commande.setDateCommande(LocalDate.now());
        for (LigneCommande ligneCommande : commande.getLigneCommandeList()) {
            ligneCommande.setCommande(commande);
        }
        ligneCommandeRepository.saveAll(commande.getLigneCommandeList());
    }
}
