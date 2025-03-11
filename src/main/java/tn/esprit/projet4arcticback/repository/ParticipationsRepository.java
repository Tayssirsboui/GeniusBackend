package tn.esprit.projet4arcticback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.entity.Participations;

@Repository
public interface ParticipationsRepository extends JpaRepository<Participations ,Long >{
}
