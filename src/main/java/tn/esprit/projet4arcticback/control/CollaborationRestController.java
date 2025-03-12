package tn.esprit.projet4arcticback.control;

//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Collaboration;
import tn.esprit.projet4arcticback.service.ICollaborationService;

import java.util.List;

//@Tag(name = "Gestion Collaboration")
@RestController
@AllArgsConstructor
@RequestMapping("/collaboration")
public class CollaborationRestController {

    @Autowired
    ICollaborationService collaborationService;

//    @Operation(description = "Récupérer toutes les collaborations")
    @GetMapping("/retrieve-all-collaborations")
    public List<Collaboration> getCollaborations() {
        return collaborationService.retrieveAllCollaborations();
    }

//    @Operation(description = "Récupérer une collaboration par ID")
    @GetMapping("/retrieve-collaboration/{collaboration-id}")
    public Collaboration retrieveCollaboration(@PathVariable("collaboration-id") Long collaborationId) {
        return collaborationService.retrieveCollaboration(collaborationId);
    }

//    @Operation(description = "Ajouter une collaboration")
    @PostMapping("/add-collaboration")
    public Collaboration addCollaboration(@RequestBody Collaboration c) {
        return collaborationService.addCollaboration(c);
    }

//    @Operation(description = "Supprimer une collaboration")
    @DeleteMapping("/remove-collaboration/{collaboration-id}")
    public void removeCollaboration(@PathVariable("collaboration-id") Long collaborationId) {
        collaborationService.removeCollaboration(collaborationId);
    }

//    @Operation(description = "Modifier une collaboration")
    @PutMapping("/modify-collaboration")
    public Collaboration modifyCollaboration(@RequestBody Collaboration c) {
        return collaborationService.modifyCollaboration(c);
    }
}
