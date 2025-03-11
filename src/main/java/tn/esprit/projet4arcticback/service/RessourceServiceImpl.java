package tn.esprit.projet4arcticback.service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Ressource;

import java.util.List;
import tn.esprit.projet4arcticback.repository.RessourceRepository;
@Service
@AllArgsConstructor
public class RessourceServiceImpl implements IRessourceService{
    @Autowired
    private RessourceRepository ressourceRepository;

    @Override
    public List<Ressource> retrieveAllRessources() {
        return ressourceRepository.findAll();
    }

    @Override
    public Ressource retrieveRessource(Long idRessource) {
        return ressourceRepository.findById(idRessource).get();

    }

    @Override
    public Ressource addRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }

    @Override
    public void removeRessource(Long idRessource) {
        ressourceRepository.deleteById(idRessource);
    }

    @Override
    public Ressource modifyRessource(Ressource ressource) {
        return ressourceRepository.save(ressource);
    }
}
