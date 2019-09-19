package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorie")
@EntityListeners(AuditingEntityListener.class)
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_categorie")
    private Integer numeroCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie")
    @JsonBackReference
    private List<Produit> produitList;

    /**
     * Constructeur
     */
    public Categorie() {
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    /**
     * Getters et Setters
     */
    public Integer getNumeroCategorie() {
        return numeroCategorie;
    }

    public void setNumeroCategorie(Integer numeroCategorie) {
        this.numeroCategorie = numeroCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public List<Produit> getProduitList() {
        return produitList;
    }

    public void setProduitList(List<Produit> produitList) {
        this.produitList = produitList;
    }
}
