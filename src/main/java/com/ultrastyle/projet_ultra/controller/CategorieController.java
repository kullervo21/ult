package com.ultrastyle.projet_ultra.controller;

import com.ultrastyle.projet_ultra.repository.CategorieRepository;
import com.ultrastyle.projet_ultra.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController
@CrossOrigin("http://localhost:4200")
public class CategorieController {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @GetMapping({"/listCategorie"})
    public List<Categorie> getListCategorie(){
        return categorieRepository.findAll();
    }

    @DeleteMapping({"/deleteCategorie/{id}"})
    public void deleteCategorie(@PathVariable Integer id){
        System.out.println("");
        System.out.println("***********************************************");
        System.out.println("");
        System.out.println("valeur supprimée : " + id);
        System.out.println("");
        System.out.println("***********************************************");
        categorieRepository.deleteById(id);
    }

    // TODO : condition retourne tjs true, mettre try catch
    @PostMapping({"/addCategorie"})
    public ResponseEntity<String> addCategorie(@RequestBody Categorie categorie) {
        ResponseEntity response = new ResponseEntity(null);
        try {
            categorieRepository.save(categorie);
            response.status(HttpStatus.CREATED).body("{\"message\":\"Catégorie créé avec succès\"}");
        } catch (Exception e) {
            System.out.println("Problem during the persistence");
            response.status(HttpStatus.METHOD_FAILURE).body("{\"message\":\"La catégorie n'est pas créé avec succès\"}");
            throw (e);
        } finally {
            System.out.println("Transaction end !");
        }
        return response;
    }
}
