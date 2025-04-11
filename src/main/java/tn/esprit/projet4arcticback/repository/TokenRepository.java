package tn.esprit.projet4arcticback.repository;
import tn.esprit.projet4arcticback.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token , Long> {
    Optional<Token> findTokenByToken(String token);
}
