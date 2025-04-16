package tn.esprit.projet4arcticback.dto;

import lombok.Getter;
import lombok.Setter;
import tn.esprit.projet4arcticback.entity.StatutParticipation;

@Getter
@Setter
public class ParticipationDTO {
    private Long evenementId;
    private StatutParticipation statut;
    private Long utilisateurId; // pour calendar
}