package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String categorie;
    private String statut;
    private Date dateCreation;
    private Date dateFinPrevue;
    private int nombreMaxCollaborateurs;

    @ElementCollection
    private List<String> competencesRequises;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projet")
    private Set<Collaboration> collaborations;
}
