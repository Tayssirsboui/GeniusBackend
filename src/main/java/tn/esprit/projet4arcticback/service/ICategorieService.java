package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Categorie;

import java.util.List;

public interface ICategorieService {
    List<Categorie> retrieveAllCategories();

    Categorie retrieveCategorie(Long idCategorie);

    Categorie addCategorie(Categorie categorie);

    void removeCategorie(Long idCategorie);

    Categorie modifyCategorie(Categorie categorie);
}
