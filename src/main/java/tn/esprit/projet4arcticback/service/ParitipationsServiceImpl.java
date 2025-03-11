package tn.esprit.projet4arcticback.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Participations;
import tn.esprit.projet4arcticback.repository.ParticipationsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ParitipationsServiceImpl implements IParticipationsService  {

     ParticipationsRepository participationsRepository;


    public List<Participations> retrieveAllParticipations() {
        return participationsRepository.findAll();
    }


    public Participations retrieveParticipation(Long idParticipation) {
        return participationsRepository.findById(idParticipation).get();
    }


    public Participations addParticipation(Participations participation) {
        return participationsRepository.save(participation);
    }


    public void removeParticipation(Long idParticipation) {
        participationsRepository.deleteById(idParticipation);
    }


    public Participations modifyParticipation(Participations participation) {
        return participationsRepository.save(participation);
    }

}
