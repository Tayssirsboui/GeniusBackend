package tn.esprit.projet4arcticback.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evenements {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String titre;
    private String description;
    private Date  dateDebut;
    private Date  dateFin;
    private String lieu;
    private String categorie;
    private Integer nbMaxParticipants;
    @Enumerated(EnumType.STRING)
    private StatutEvenement statut;
    private LocalDateTime dateCreation = LocalDateTime.now();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "evenement")
    private Set<Participations> participations;

}
