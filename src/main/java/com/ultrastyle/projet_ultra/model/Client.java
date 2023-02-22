package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente un objet Client.
 * Elle est utilisée pour stocker les informations des clients
 * et pour mapper ces informations à une table de la base de données.
 *
 * Elle est annotée avec @Entity pour indiquer que c'est une entité JPA.
 * Les propriétés sont annotées avec @Column pour mapper chaque propriété
 * à une colonne de la table.
 *
 * Les annotations @Getter et @Setter sont des annotations de Lombok qui
 * génèrent automatiquement les méthodes getter et setter pour les propriétés.
 *
 * L'annotation @EntityListeners(AuditingEntityListener.class) est utilisée
 * pour activer les auditeurs JPA qui permettent de mettre à jour automatiquement
 * les propriétés créées et modifiées, ainsi que les dates de création et de modification
 * lorsqu'un client est créé ou mis à jour.
 */
@Entity // Indique que cette classe est une entité JPA
@Getter // Génère automatiquement les getters pour toutes les propriétés de la classe
@Setter // Génère automatiquement les setters pour toutes les propriétés de la classe
@Table(name="client")
@EntityListeners(AuditingEntityListener.class) // Active la fonctionnalité d'auditing pour cette entité
public class Client implements Serializable {

    @Id // Indique que cette propriété est la clé primaire de l'entité
    @Column(name = "adresseMail") // Spécifie le nom de la colonne dans la table de la base de données
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
    @Column(name ="admin",columnDefinition = "boolean default false") // Spécifie la définition de la colonne dans la table de la base de données
    private Boolean admin = false;
    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.EAGER) // Indique qu'il y a une relation One-to-One entre cette entité et l'entité spécifiée par la propriété "role"
    @JoinColumn(name = "role_id") // Spécifie le nom de la colonne qui fait référence à la clé primaire de l'entité liée
    private Role role;

    @Transient // Indique que cette propriété n'est pas persistante, c'est-à-dire qu'elle n'est pas stockée dans la base de données
    private List<LigneCommande> panier = new ArrayList<>();

    @JsonBackReference("commande") // Indique que cette propriété est ignorée lors de la sérialisation en JSON pour éviter une boucle infinie
    @OneToMany(mappedBy = "client") // Indique qu'il y a une relation One-to-Many entre cette entité et l'entité spécifiée par la propriété "commandeList"
    private List<Commande> commandeList;

    /**
     * Constructeurs
     */
    public Client() {
    }

}
