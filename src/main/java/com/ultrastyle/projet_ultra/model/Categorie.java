package com.ultrastyle.projet_ultra.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categorie")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_categorie")
    @JsonIgnore
    private Integer numeroCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie")
    @JsonBackReference
    @ToString.Exclude
    private List<Produit> produitList;

    /**
     * Constructeur
     */

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}

