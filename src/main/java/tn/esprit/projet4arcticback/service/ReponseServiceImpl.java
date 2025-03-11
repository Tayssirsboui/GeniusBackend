package tn.esprit.projet4arcticback.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Reponse;
import tn.esprit.projet4arcticback.repository.ReponseRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ReponseServiceImpl implements IReponseService {
    @Autowired
    ReponseRepository reponseRepository;
    public List<Reponse> retrieveAllReponses() {
        return reponseRepository.findAll();
    }
    public Reponse retrieveReponse(Long idReponse) {

        return reponseRepository.findById(idReponse).orElse(null);
    }
    public Reponse addReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }
    public void removeReponse(Long reponseId) {
        reponseRepository.deleteById(reponseId);
    }
    public Reponse modifyReponse(Reponse reponse) {

        return reponseRepository.save(reponse);
    }
}

