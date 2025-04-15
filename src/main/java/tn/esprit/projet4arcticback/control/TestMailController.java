package tn.esprit.projet4arcticback.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.repository.EvenementsRepository;
import tn.esprit.projet4arcticback.service.IListeAttenteService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestMailController {

    private final IListeAttenteService listeAttenteService;
    private final EvenementsRepository evenementsRepository;

    @GetMapping("/notifier/{id}")
    public void testNotif(@PathVariable Long id) {
        Evenements event = evenementsRepository.findById(id).orElseThrow();
        listeAttenteService.notifierPremierEnAttente(event);
    }
}