package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.LigneCommandeRepository;
import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class LigneCommandeController {

    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public LigneCommandeController(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @GetMapping({"/listLigneCommande"})
    public List<LigneCommande> getListLigne(){
        return ligneCommandeRepository.findAll();
    }


}

