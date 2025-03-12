package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Projet;

import java.util.List;

public interface IProjetService {
    List<Projet> retrieveAllProjets();
    Projet retrieveProjet(Long projetId);
    Projet addProjet(Projet p);
    void removeProjet(Long projetId);
    Projet modifyProjet(Projet projet);
}
