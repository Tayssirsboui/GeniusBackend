package tn.esprit.projet4arcticback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.entity.ListeAttente;

public interface ListeAttenteRepository extends JpaRepository<ListeAttente, Long> {
    ListeAttente findFirstByEvenementAndNotificationEnvoyeeFalseOrderByDateInscriptionAsc(Evenements evenement);
    boolean existsByEvenementAndEmail(Evenements evenement, String email);

}
