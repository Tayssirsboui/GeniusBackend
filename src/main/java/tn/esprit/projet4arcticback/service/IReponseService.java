package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Reponse;

import java.util.List;

public interface IReponseService {
    public List<Reponse > retrieveAllReponses();
    public Reponse retrieveReponse(Long idReponse);
    public Reponse addReponse(Reponse reponse);
    public void removeReponse(Long idReponse);
    public Reponse modifyReponse(Reponse reponse);
}
