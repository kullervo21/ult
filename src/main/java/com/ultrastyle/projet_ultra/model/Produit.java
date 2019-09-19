package com.ultrastyle.projet_ultra.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produit")
@EntityListeners(AuditingEntityListener.class)
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_produit")
    private Integer numeroProduit;
    @Column(name = "nom_produit")
    private String nomProduit;
    @Column(name = "descriptif_produit")
    private String descriptifProduit;
    @Column(name = "prix")
    private BigDecimal prix;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "numero_categorie")
  //  @JsonManagedReference
    private Categorie categorie;

    /**
     * Constructeur
     */
    public Produit() {
    }

    public Produit(String nomProduit, String descriptifProduit, BigDecimal prix, String image) {
        this.nomProduit = nomProduit;
        this.descriptifProduit = descriptifProduit;
        this.prix = prix;
        this.image = image;
    }

    /**
     * Getters et Setters
     */
    public Integer getNumeroProduit() {
        return numeroProduit;
    }

    public void setNumeroProduit(Integer numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public String getDescriptifProduit() {
        return descriptifProduit;
    }

    public void setDescriptifProduit(String descriptifProduit) {
        this.descriptifProduit = descriptifProduit;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
