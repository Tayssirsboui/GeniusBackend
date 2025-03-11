package tn.esprit.projet4arcticback.control;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.service.IEvenementsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/evenements")
public class EvenementsRestController {

    IEvenementsService evenementsService;

    // http://localhost:8089/backend/evenements/retrieve-all-evenements
    @GetMapping("/retrieve-all-evenements")
    public List<Evenements> getEvenements() {
        List<Evenements> listEvenements = evenementsService.retrieveAllEvenements();
        return listEvenements;
    }

    // http://localhost:8089/backend/evenements/retrieve-evenement/{id}
    @GetMapping("/retrieve-evenement/{evenement-id}")
    public Evenements retrieveEvenement(@PathVariable("evenement-id") Long evenementId) {
        Evenements evenement = evenementsService.retrieveEvenement(evenementId);
        return evenement;
    }

    // http://localhost:8089/backend/evenements/add-evenement
    @PostMapping("/add-evenement")
    public Evenements addEvenement(@RequestBody Evenements e) {
        Evenements evenement = evenementsService.addEvenement(e);
        return evenement;
    }

    // http://localhost:8089/backend/evenements/remove-evenement/{evenement-id}
    @DeleteMapping("/remove-evenement/{evenement-id}")
    public void removeEvenement(@PathVariable("evenement-id") Long evenementId) {
        evenementsService.removeEvenement(evenementId);
    }

    // http://localhost:8089/backend/evenements/modify-evenement
    @PutMapping("/modify-evenement")
    public Evenements modifyEvenement(@RequestBody Evenements e) {
        Evenements evenement = evenementsService.modifyEvenement(e);
        return evenement;
    }
}
