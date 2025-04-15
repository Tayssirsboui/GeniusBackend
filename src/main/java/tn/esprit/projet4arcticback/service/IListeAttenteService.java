package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.entity.ListeAttente;

public interface IListeAttenteService {
    ListeAttente inscrire(ListeAttente demande);
    void notifierPremierEnAttente(Evenements evenement);

}
