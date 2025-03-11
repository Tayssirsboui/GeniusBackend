package tn.esprit.projet4arcticback.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.repository.EvenementsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EvenementsServiceImpl implements IEvenementsService {

     EvenementsRepository evenementsRepository;


    public List<Evenements> retrieveAllEvenements() {
        return evenementsRepository.findAll();
    }


    public Evenements retrieveEvenement(Long idEvenement) {
        return evenementsRepository.findById(idEvenement).get() ;
    }


    public Evenements addEvenement(Evenements evenement) {
        return evenementsRepository.save(evenement);
    }


    public void removeEvenement(Long idEvenement) {
        evenementsRepository.deleteById(idEvenement);
    }


    public Evenements modifyEvenement(Evenements evenement) {
        return evenementsRepository.save(evenement);
    }
}
