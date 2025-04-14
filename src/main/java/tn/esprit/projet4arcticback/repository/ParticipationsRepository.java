package tn.esprit.projet4arcticback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.entity.Participations;

@Repository
public interface ParticipationsRepository extends JpaRepository<Participations ,Long >{

    @Query("SELECT COUNT(p) FROM Participations p WHERE p.evenement.id = :eventId")
    Long countByEvenementId(@Param("eventId") Long eventId);
}
