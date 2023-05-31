package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.dao.ClientDao;
import com.ultrastyle.projet_ultra.dao.ProduitDao;
import com.ultrastyle.projet_ultra.model.Client;
import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProduitController {

    private ProduitDao produitDao;

    @Autowired
    public ProduitController(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

    @GetMapping({"/listProduit"})
    public List<Produit> getProduitList() {
        return produitDao.findAll();
    }


}
