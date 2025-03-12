package tn.esprit.projet4arcticback.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Projet;
import tn.esprit.projet4arcticback.repository.ProjetRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjetServiceImpl implements IProjetService {
    @Autowired
    private ProjetRepository projetRepository;

    public List<Projet> retrieveAllProjets() {
        return projetRepository.findAll();
    }

    public Projet retrieveProjet(Long projetId) {
        return projetRepository.findById(projetId).orElse(null);
    }

    public Projet addProjet(Projet p) {
        return projetRepository.save(p);
    }

    public void removeProjet(Long projetId) {
        projetRepository.deleteById(projetId);
    }

    public Projet modifyProjet(Projet projet) {
        return projetRepository.save(projet);
    }
}
