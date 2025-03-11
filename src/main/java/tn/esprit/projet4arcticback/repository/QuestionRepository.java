package tn.esprit.projet4arcticback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projet4arcticback.entity.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
