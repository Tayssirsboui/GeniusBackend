package tn.esprit.projet4arcticback.service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Categorie;
import tn.esprit.projet4arcticback.repository.CategorieRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieSercieImpl implements ICategorieService{
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<Categorie> retrieveAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie retrieveCategorie(Long idCategorie) {
        return categorieRepository.findById(idCategorie).get();

    }

    @Override
    public Categorie addCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void removeCategorie(Long idCategorie) {
        categorieRepository.deleteById(idCategorie);
    }

    @Override
    public Categorie modifyCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

}
