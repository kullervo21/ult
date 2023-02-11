package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.ProduitRepository;
import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

// Indique que les transactions sont gérées par le framework Spring
@Transactional
// Indique que cette classe est un contrôleur REST
@RestController
// Autorise les requêtes cross-origin à partir de "http://localhost:4200"
@CrossOrigin("http://localhost:4200")
public class ProduitController {

    // Instance du repository pour les produits
    private final ProduitRepository produitRepository;

    // Injection d'une instance du repository via le constructeur
    @Autowired
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    // Récupère la liste de tous les produits en appelant la méthode findAll() du repository
    @GetMapping({"/listProduit"})
    public List<Produit> getProduitList() {
        return produitRepository.findAll();
    }

    // Ajoute un nouveau produit en appelant la méthode save() du repository
    @PostMapping({"/addProduit"})
    public void addProduit(@RequestBody Produit produit) {
        produitRepository.save(produit);
    }

    // Récupère la liste des produits ayant un prix supérieur à celui spécifié en utilisant la méthode findByPrixGreaterThan() du repository
    @GetMapping(value = "/produits/{prixLimit}")
    public List<Produit> getProduitLimit(@PathVariable BigDecimal prixLimit)
    { return produitRepository.findByPrixGreaterThan(prixLimit); }

}
