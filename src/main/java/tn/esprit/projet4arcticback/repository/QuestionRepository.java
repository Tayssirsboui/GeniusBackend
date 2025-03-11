package tn.esprit.projet4arcticback.repository;

import tn.esprit.projet4arcticback.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
