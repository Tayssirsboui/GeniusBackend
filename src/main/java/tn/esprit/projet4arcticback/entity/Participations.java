package tn.esprit.projet4arcticback.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private LocalDateTime dateInscription = LocalDateTime.now();

    @Enumerated(EnumType.STRING )
    private StatutParticipation statut;

    @ManyToOne
    private Evenements  evenement;

}
