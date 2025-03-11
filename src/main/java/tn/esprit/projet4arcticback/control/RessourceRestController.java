package tn.esprit.projet4arcticback.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Ressource;
import tn.esprit.projet4arcticback.service.IRessourceService;

import java.util.List;

@Tag(name = "Gestion des Ressources")
@RestController
@AllArgsConstructor
@RequestMapping("/ressource")

public class RessourceRestController {
    @Autowired
    private IRessourceService ressourceService;

    @Operation(description = "Récupérer toutes les ressources")
    @GetMapping("/retrieve-all-ressources")
    public List<Ressource> getRessources() {
        return ressourceService.retrieveAllRessources();
    }

    @Operation(description = "Récupérer une ressource par son ID")
    @GetMapping("/retrieve-ressource/{ressource-id}")
    public Ressource retrieveRessource(@PathVariable("ressource-id") Long idRessource) {
        return ressourceService.retrieveRessource(idRessource);
    }
//http://localhost:8089/backend/ressource/add-ressource
    @Operation(description = "Ajouter une nouvelle ressource")
    @PostMapping("/add-ressource")
    public Ressource addRessource(@RequestBody Ressource ressource) {
        return ressourceService.addRessource(ressource);
    }

    @Operation(description = "Supprimer une ressource par son ID")
    @DeleteMapping("/remove-ressource/{ressource-id}")
    public void removeRessource(@PathVariable("ressource-id") Long idRessource) {
        ressourceService.removeRessource(idRessource);
    }

    @Operation(description = "Modifier une ressource existante")
    @PutMapping("/modify-ressource")
    public Ressource modifyRessource(@RequestBody Ressource ressource) {
        return ressourceService.modifyRessource(ressource);
    }
}
