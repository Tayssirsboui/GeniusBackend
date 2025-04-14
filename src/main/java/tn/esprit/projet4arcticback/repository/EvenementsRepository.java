package tn.esprit.projet4arcticback.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Evenements;

import java.util.Optional;

@Repository
public interface EvenementsRepository extends JpaRepository<Evenements ,Long >{
    @Query("SELECT e FROM Evenements e LEFT JOIN FETCH e.participations WHERE e.id = :id")
    Optional<Evenements> findByIdWithParticipations(@Param("id") Long id);

}
