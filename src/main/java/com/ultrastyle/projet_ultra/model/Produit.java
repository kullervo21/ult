package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Cette classe représente un produit de l'application.
 */
@Entity
@Table( name = "produit" )
@EntityListeners( AuditingEntityListener.class )
public class Produit implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "numero_produit" )
    private Integer numeroProduit;

    @Column( name = "nom_produit" )
    private String nomProduit;

    @Column( name = "descriptif_produit" )
    private String descriptifProduit;

    @Column( name = "prix" )
    private BigDecimal prix;

    @Column( name = "image" )
    private String image;

    @ManyToOne
    @JoinColumn( name = "numero_categorie" )
    // @JsonManagedReference
    private Categorie categorie;

    /**
     * Constructeur par défaut
     */
    public Produit() {
    }

    /**
     * Constructeur avec paramètres
     *
     * @param nomProduit        Le nom du produit
     * @param descriptifProduit Le descriptif du produit
     * @param prix              Le prix du produit
     * @param image             Le chemin d'accès à l'image du produit
     */
    public Produit(String nomProduit, String descriptifProduit, BigDecimal prix, String image) {
        this.nomProduit = nomProduit;
        this.descriptifProduit = descriptifProduit;
        this.prix = prix;
        this.image = image;
    }

    /**
     * Getter pour l'identifiant du produit
     *
     * @return L'identifiant du produit
     */
    public Integer getNumeroProduit() {
        return numeroProduit;
    }

    /**
     * Setter pour l'identifiant du produit
     *
     * @param numeroProduit Le nouvel identifiant du produit
     */
    public void setNumeroProduit(Integer numeroProduit) {
        this.numeroProduit = numeroProduit;
    }

    /**
     * Getter pour le nom du produit
     *
     * @return Le nom du produit
     */
    public String getNomProduit() {
        return nomProduit;
    }

    /**
     * Setter pour le nom du produit
     *
     * @param nomProduit Le nouveau nom du produit
     */
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    /**
     * Getter pour le descriptif du produit
     *
     * @return Le descriptif du produit
     */
    public String getDescriptifProduit() {
        return descriptifProduit;
    }

    /**
     * Setter pour le descriptif du produit
     *
     * @param descriptifProduit Le nouveau descriptif du produit
     */
    public void setDescriptifProduit(String descriptifProduit) {
        this.descriptifProduit = descriptifProduit;
    }

    /**
     * Getter pour le prix du produit
     *
     * @return Le prix du produit
     */
    public BigDecimal getPrix() {
        return prix;
    }

    /**
     * Setter pour le prix du produit
     *
     * @param prix Le nouveau prix du produit
     */
    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    /**
     * Getter pour le chemin d'accès à l'image du produit
     *
     * @return le lien vers l'image du produit.
     */
    public String getImage() {
        return image;
    }


    /**
     * Setter pour l'image de produit
     *
     * @param image La nouvelle image de produit
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Getter pour la catégorie de produit
     *
     * @return La catégorie de produit
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * Setter pour la catégorie de produit
     *
     * @param categorie La nouvelle catégorie de produit
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}