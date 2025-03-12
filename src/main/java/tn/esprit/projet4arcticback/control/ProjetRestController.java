package tn.esprit.projet4arcticback.control;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Projet;
import tn.esprit.projet4arcticback.service.IProjetService;

import java.util.List;

//@Tag(name = "Gestion Projet")
@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {

    @Autowired
     IProjetService projetService;

//    @Operation(description = "Récupérer tous les projets")
    @GetMapping("/retrieve-all-projets")
    public List<Projet> getProjets() {
        return projetService.retrieveAllProjets();
    }

//    @Operation(description = "Récupérer un projet par ID")
    @GetMapping("/retrieve-projet/{projet-id}")
    public Projet retrieveProjet(@PathVariable("projet-id") Long projetId) {
        return projetService.retrieveProjet(projetId);
    }

//    @Operation(description = "Ajouter un projet")
    @PostMapping("/add-projet")
    public Projet addProjet(@RequestBody Projet p) {
        return projetService.addProjet(p);
    }

//    @Operation(description = "Supprimer un projet")
    @DeleteMapping("/remove-projet/{projet-id}")
    public void removeProjet(@PathVariable("projet-id") Long projetId) {
        projetService.removeProjet(projetId);
    }

//    @Operation(description = "Modifier un projet")
    @PutMapping("/modify-projet")
    public Projet modifyProjet(@RequestBody Projet p) {
        return projetService.modifyProjet(p);
    }
}
