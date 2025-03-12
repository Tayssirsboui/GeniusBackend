package tn.esprit.projet4arcticback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Projet;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {
}
