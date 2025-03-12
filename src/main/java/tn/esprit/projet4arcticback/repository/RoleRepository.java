package tn.esprit.projet4arcticback.repository;

import tn.esprit.projet4arcticback.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
     Role findByRoleName(String roleName);
}
