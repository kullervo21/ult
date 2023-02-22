package com.ultrastyle.projet_ultra.controller;
import com.ultrastyle.projet_ultra.repository.ProduitRepository;
import com.ultrastyle.projet_ultra.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Le contrôleur ProduitController permet de gérer les produits via une API REST.
 */
/**
 * Indique que les transactions sont gérées par le framework Spring.
 * Cette annotation est utilisée pour gérer la transaction de la base de données.
 * Elle permet d'assurer l'intégrité de la base de données en cas d'opérations multiples.
 */
@Transactional
/**
 * Indique que cette classe est un contrôleur REST.
 * Cette annotation est utilisée pour indiquer que la classe sera utilisée pour exposer des services Web RESTful.
 * Elle permet de recevoir des requêtes HTTP et de renvoyer des réponses HTTP dans un format adapté à la demande du client.
 */
@RestController
/**
 * Autorise les requêtes cross-origin à partir de "http://localhost:4200".
 * Cette annotation est utilisée pour permettre les requêtes cross-origin (CORS).
 * Elle permet de définir des politiques de sécurité pour l'accès à des ressources depuis un domaine différent.
 */
@CrossOrigin("http://localhost:4200")
public class ProduitController {

    // Instance du repository pour les produits
    private final ProduitRepository produitRepository;

    /**
     * Constructeur de la classe ProduitController qui permet d'injecter une instance du repository ProduitRepository.
     * @param produitRepository le repository pour les produits
     */
    @Autowired
    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    /**
     * Récupère la liste de tous les produits en appelant la méthode findAll() du repository.
     * @return la liste de tous les produits
     */
    @GetMapping({"/admin/listProduit"})
    public List<Produit> getProduitList() {
        return produitRepository.findAll();
    }

    /**
     * Récupère le produit correspondant à l'ID spécifié en appelant la méthode findByNumeroProduit() du repository.
     * @param id l'identifiant du produit à récupérer
     * @return le produit correspondant à l'ID spécifié
     */
    @GetMapping({"/admin/{id}/listProduit/"})
    public Produit getProduitListById(@PathVariable Integer id) {
        Optional<Produit> produitOptional = produitRepository.findByNumeroProduit(id);
        if (produitOptional.isPresent()) {
            Produit produit = produitOptional.get();
            return produit;
        } else {
            return null;
        }
    }

    /**
     * Ajoute un nouveau produit en appelant la méthode save() du repository.
     * @param produit le produit à ajouter
     */
    @PostMapping({"/addProduit"})
    public void addProduit(@RequestBody Produit produit) {
        produitRepository.save(produit);
    }

    /**
     * Récupère la liste des produits ayant un prix supérieur à celui spécifié en utilisant la méthode findByPrixGreaterThan() du repository.
     * @param prixLimit le prix limite pour la récupération des produits
     * @return la liste des produits ayant un prix supérieur à celui spécifié
     */
    @GetMapping(value = "/produits/{prixLimit}")
    public List<Produit> getProduitLimit(@PathVariable BigDecimal prixLimit)
    { return produitRepository.findByPrixGreaterThan(prixLimit); }

}
