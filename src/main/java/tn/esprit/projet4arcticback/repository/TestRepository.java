package tn.esprit.projet4arcticback.repository;

import tn.esprit.projet4arcticback.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepository extends JpaRepository<Test, Long> {
    Optional<Test> findById(Long id);

}
