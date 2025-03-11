package tn.esprit.projet4arcticback.control;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Participations;
import tn.esprit.projet4arcticback.service.IParticipationsService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/participations")
public class ParticipationsRestController {
    IParticipationsService participationsService;

    // http://localhost:8089/backend/participations/retrieve-all-participations
    @GetMapping("/retrieve-all-participations")
    public List<Participations> getParticipations() {
        List<Participations> listParticipations = participationsService.retrieveAllParticipations();
        return listParticipations;
    }

    // http://localhost:8089/backend/participations/retrieve-participation/{participation-id}
    @GetMapping("/retrieve-participation/{participation-id}")
    public Participations retrieveParticipation(@PathVariable("participation-id") Long participationId) {
        Participations participation = participationsService.retrieveParticipation(participationId);
        return participation;
    }

    // http://localhost:8089/backend/participations/add-participation
    @PostMapping("/add-participation")
    public Participations addParticipation(@RequestBody Participations p) {
        Participations participation = participationsService.addParticipation(p);
        return participation;
    }

    // http://localhost:8089/backend/participations/remove-participation/{participation-id}
    @DeleteMapping("/remove-participation/{participation-id}")
    public void removeParticipation(@PathVariable("participation-id") Long participationId) {
        participationsService.removeParticipation(participationId);
    }

    // http://localhost:8089/backend/participations/modify-participation
    @PutMapping("/modify-participation")
    public Participations modifyParticipation(@RequestBody Participations p) {
        Participations participation = participationsService.modifyParticipation(p);
        return participation;
    }


}
