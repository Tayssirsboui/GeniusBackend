package tn.esprit.projet4arcticback.control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.ListeAttente;
import tn.esprit.projet4arcticback.service.IListeAttenteService;

@RestController
@RequestMapping("/liste-attente")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ListeAttenteRestController {

    private final IListeAttenteService listeAttenteService;

    @PostMapping("/inscrire") // ✅ le chemin attendu est /liste-attente/inscrire
    public ResponseEntity<ListeAttente> inscrire(@RequestBody ListeAttente demande) {
        ListeAttente saved = listeAttenteService.inscrire(demande);
        return ResponseEntity.ok(saved);
    }
}




