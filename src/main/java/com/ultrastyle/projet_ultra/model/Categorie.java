package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * La classe Categorie représente une catégorie de produits.
 */
@Entity // Cette annotation indique que cette classe est une entité persistante qui sera stockée en base de données.
@Table(name = "categorie") // Cette annotation spécifie le nom de la table correspondant à cette entité en base de données.
@Getter // Cette annotation est fournie par Lombok et génère automatiquement les getters pour les propriétés de cette classe.
@Setter // Cette annotation est fournie par Lombok et génère automatiquement les setters pour les propriétés de cette classe.
@ToString // Cette annotation est fournie par Lombok et génère automatiquement la méthode toString() pour cette classe.
@RequiredArgsConstructor // Cette annotation est fournie par Lombok et génère automatiquement un constructeur avec tous les champs marqués comme final ou @NonNull.
@EntityListeners(AuditingEntityListener.class) // Cette annotation spécifie que cette entité doit être écoutée par la classe AuditingEntityListener, qui gère les annotations @CreatedBy, @LastModifiedBy, @CreatedDate et @LastModifiedDate pour remplir automatiquement les champs de suivi de l'entité en fonction des modifications apportées à celle-ci.
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_categorie")
    @JsonIgnore // Ignore le numéro de catégorie dans la sérialisation JSON
    private Integer numeroCategorie;

    /**
     * Le nom de la catégorie.
     */
    @Column(name = "nom_categorie")
    private String nomCategorie;

    /**
     * La liste des produits de la catégorie.
     */
    @OneToMany(mappedBy = "categorie")
    @JsonBackReference // Ignore la référence circulaire dans la sérialisation JSON
    @ToString.Exclude // Exclut la liste des produits dans la méthode toString() pour éviter une boucle infinie
    private List<Produit> produitList;

    /**
     * Constructeur de la classe Categorie.
     * @param nomCategorie le nom de la catégorie
     */
    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}
