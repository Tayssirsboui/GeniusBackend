package tn.esprit.projet4arcticback.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;
import tn.esprit.projet4arcticback.entity.Discussion;
import tn.esprit.projet4arcticback.entity.Forum;

@Repository

public interface ForumRepository extends JpaRepository<Forum, Long>{
}
