package tn.esprit.projet4arcticback.control;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Reponse;
import tn.esprit.projet4arcticback.service.ReponseServiceImpl;

import java.util.List;

@Tag(name = "Gestion des Réponses")
@RestController
@AllArgsConstructor
@RequestMapping("/reponse")
public class ReponseRestController {
    @Autowired

    ReponseServiceImpl reponseService;

    // Récupérer toutes les réponses
    @Operation(description = "Récupérer la liste de toutes les réponses enregistrées")
    @GetMapping("/retrieve-all-reponses")
    public List<Reponse>findAll() {
        return reponseService.retrieveAllReponses();
    }
    // Récupérer une réponse par ID
    @Operation(description = "Récupérer une réponse spécifique en fournissant son ID")
    @GetMapping("/retrieve-reponse/{reponse-id}")
    public Reponse retrieveReponse(@PathVariable("reponse-id") Long reponseId) {
        return reponseService.retrieveReponse(reponseId);
    }

    // Ajouter une nouvelle réponse
    @Operation(description = "Ajouter une nouvelle réponse")
    @PostMapping("/add-reponse")
    public Reponse addReponse(@RequestBody Reponse reponse) {
        return reponseService.addReponse(reponse);
    }

    // Supprimer une réponse par ID
    @Operation(description = "Supprimer une réponse en fournissant son ID")
    @DeleteMapping("/remove-reponse/{reponse-id}")
    public void removeReponse(@PathVariable("reponse-id") Long reponseId) {
        reponseService.removeReponse(reponseId);
    }

    // Modifier une réponse existante
    @Operation(description = "Mettre à jour les informations d'une réponse existante")
    @PutMapping("/modify-reponse")
    public Reponse modifyReponse(@RequestBody Reponse reponse) {
        return reponseService.modifyReponse(reponse);
    }
}

