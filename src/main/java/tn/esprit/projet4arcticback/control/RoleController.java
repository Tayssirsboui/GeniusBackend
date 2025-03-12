package tn.esprit.projet4arcticback.control;

import tn.esprit.projet4arcticback.entity.Role;
import tn.esprit.projet4arcticback.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    // Ajouter un rôle
    @PostMapping("/add")
    public ResponseEntity<Role> addRole(@RequestBody Role role) {
        return ResponseEntity.ok(roleService.addRole(role));
    }

    // Récupérer un rôle par nom
    @GetMapping("/role/{roleName}")
    public ResponseEntity<Role> getRole(@PathVariable String roleName) {
        Role role = roleService.getRoleByName(roleName);
        return role != null ? ResponseEntity.ok(role) : ResponseEntity.notFound().build();
    }

    // Mettre à jour un rôle
    @PutMapping("/update")
    public ResponseEntity<Role> updateRole(@RequestBody Role role) {
        Role updatedRole = roleService.updateRole(role);
        return updatedRole != null ? ResponseEntity.ok(updatedRole) : ResponseEntity.notFound().build();
    }

    // Supprimer un rôle par ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
