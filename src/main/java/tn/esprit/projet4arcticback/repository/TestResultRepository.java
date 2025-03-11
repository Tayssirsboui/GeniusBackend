package tn.esprit.projet4arcticback.repository;

import tn.esprit.projet4arcticback.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult, Long> {
}
