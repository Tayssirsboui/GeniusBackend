package tn.esprit.projet4arcticback.entity;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
    public class Categorie {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idCategorie;

        private String nomCategorie; // Nom de la catégorie

        private String domaine; // Domaine associé (ex: Informatique, Science...)

        private String description; // Description détaillée de la catégorie
        private LocalDateTime dateCreation  = LocalDateTime.now();
        // Date de création

        private boolean active = true; // Statut actif/inactif


        @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        private List<Ressource> ressources; // Liste des ressources associées
}
