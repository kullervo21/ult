package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.ProduitRepository;
import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class ProduitController {

    private final ProduitRepository produitRepository;

    @Autowired
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping({"/listProduit"})
    public List<Produit> getProduitList() {
        return produitRepository.findAll();
    }

    @PostMapping({"/addProduit"})
    public void addProduit(@RequestBody Produit produit) {
        produitRepository.save(produit);
    }


}
