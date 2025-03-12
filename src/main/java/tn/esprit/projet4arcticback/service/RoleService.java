package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Role;
import tn.esprit.projet4arcticback.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // Ajouter un rôle
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    // Récupérer un rôle par ID
    public Role getRoleById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    // Mettre à jour un rôle
    public Role updateRole(Role role) {
        Optional<Role> existingRole = roleRepository.findById(role.getRoleId());
        if (existingRole.isPresent()) {
            return roleRepository.save(role);
        }
        return null; // Retourne null si l'ID du rôle n'existe pas
    }

    // Supprimer un rôle
    public void deleteRole(int id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
        }
    }

    // Récupérer un rôle par nom
    public Role getRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
