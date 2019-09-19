package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.dao.LigneCommandeDao;
import com.ultrastyle.projet_ultra.model.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LigneCommandeController {

    private LigneCommandeDao ligneCommandeDao;

    @Autowired
    public LigneCommandeController(LigneCommandeDao ligneCommandeDao) {
        this.ligneCommandeDao = ligneCommandeDao;
    }

    @GetMapping({"/listLigneCommande"})
    public List<LigneCommande> getListLigne(){
        return ligneCommandeDao.findAll();
    }


}

