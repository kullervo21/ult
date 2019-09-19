package com.ultrastyle.projet_ultra.controller;

import com.ultrastyle.projet_ultra.dao.CategorieDao;
import com.ultrastyle.projet_ultra.model.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CategorieController {

    private CategorieDao categorieDao;

    @Autowired
    public CategorieController(CategorieDao categorieDao) {
        this.categorieDao = categorieDao;
    }

    @GetMapping({"/listCategorie"})
    public List<Categorie> getListCategorie(){
        return categorieDao.findAll();
    }
}
