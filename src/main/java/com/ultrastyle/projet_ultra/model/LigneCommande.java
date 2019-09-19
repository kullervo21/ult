package com.ultrastyle.projet_ultra.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ligneCommande")
@EntityListeners(AuditingEntityListener.class)
public class LigneCommande implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "numero_ligne")
private Integer numeroLigne;
@Column(name = "qte_commandee")
private Integer qteCommandee;
@ManyToOne
@JoinColumn(name = "numero_commande", insertable = false, updatable = false)
private Commande commande;
@ManyToOne
@JoinColumn(name = "numero_poduit" )
private Produit produit;

/**
 * Constructeur
 */
    public LigneCommande() {
    }

    public LigneCommande(Integer qteCommandee) {
        this.qteCommandee = qteCommandee;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     * Getters et Setters
     */

    public Integer getNumeroLigne() {
        return numeroLigne;
    }

    public void setNumeroLigne(Integer numeroLigne) {
        this.numeroLigne = numeroLigne;
    }

    public Integer getQteCommandee() {
        return qteCommandee;
    }

    public void setQteCommandee(Integer qteCommandee) {
        this.qteCommandee = qteCommandee;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
