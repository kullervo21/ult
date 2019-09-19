package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="client")
@EntityListeners(AuditingEntityListener.class)
public class Client implements Serializable {

@Id
@Column(name = "adresse_mail")
private String adresse_mail;
@Column(name = "nom")
private String nom;
@Column(name = "prenom")
private String prenom;
@Column(name = "adresse")
private String adresse;
@Column(name ="cp")
private String cp;
@Column(name ="ville")
private String ville;
@Column(name ="telephone")
private String telephone;
@Column(name ="admin",columnDefinition = "boolean default false")
private Boolean admin = false;
@Column(name = "password")
private String password;

@JsonBackReference("commande")
@OneToMany(mappedBy = "client")
private List<Commande> commandeList;

    /**
     * Constructeurs
      */
    public Client() {
    }


    /**
     * Getters et Setters
     */


    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setAdresse_mail(String adresse_mail) {
        this.adresse_mail = adresse_mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
