package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="client")
@EntityListeners(AuditingEntityListener.class)
public class Client implements Serializable {

@Id
@Column(name = "adresseMail")
private String adresseMail;
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

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "role_id")
private Role role;

@Transient
private List<LigneCommande> panier = new ArrayList<>();

@JsonBackReference("commande")
@OneToMany(mappedBy = "client")
private List<Commande> commandeList;

    /**
     * Constructeurs
      */
    public Client() {
    }

}
