package tn.esprit.projet4arcticback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Evenements;

@Repository
public interface EvenementsRepository extends JpaRepository<Evenements ,Long >{
}
