package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "commande")
@EntityListeners(AuditingEntityListener.class)
public class Commande implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "numero_commande")
private Integer numeroCommande;
@Column(name = "date_commande")
private LocalDate dateCommande;
@ManyToOne
@JoinColumn(name = "adresseMail")
private Client client;
@JsonBackReference("ligneCommande")
@OneToMany(mappedBy = "commande")
private List<LigneCommande> ligneCommandeList;

/**
 * Constructeurs
 */
    public Commande() {
    }

    public Commande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }
/**
 * Getters et Setters
  */
    public Integer getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(Integer numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<LigneCommande> getLigneCommandeList() {
        return ligneCommandeList;
    }

    public void setLigneCommandeList(List<LigneCommande> ligneCommandeList) {
        this.ligneCommandeList = ligneCommandeList;
    }
}
