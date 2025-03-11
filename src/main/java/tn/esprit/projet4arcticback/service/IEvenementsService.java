package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Evenements;

import java.util.List;

public interface IEvenementsService {
    List<Evenements> retrieveAllEvenements();
    Evenements retrieveEvenement(Long idEvenement);
    Evenements addEvenement(Evenements evenement);
    void removeEvenement(Long idEvenement);
    Evenements modifyEvenement(Evenements evenement);
}
