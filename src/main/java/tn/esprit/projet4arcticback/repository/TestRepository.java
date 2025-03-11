package tn.esprit.projet4arcticback.repository;

import tn.esprit.projet4arcticback.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
}
