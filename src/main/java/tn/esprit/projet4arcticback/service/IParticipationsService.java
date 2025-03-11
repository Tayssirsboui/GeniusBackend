package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Participations;

import java.util.List;

public interface IParticipationsService {
    List<Participations> retrieveAllParticipations();
    Participations retrieveParticipation(Long idParticipation);
    Participations addParticipation(Participations participation);
    void removeParticipation(Long idParticipation);
    Participations modifyParticipation(Participations participation);
}
