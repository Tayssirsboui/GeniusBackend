package tn.esprit.projet4arcticback.control;


import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.projet4arcticback.entity.Evenements;
import tn.esprit.projet4arcticback.entity.StatutEvenement;
import tn.esprit.projet4arcticback.service.IEvenementsService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
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
   // @PostMapping("/add-evenement")
    //public Evenements addEvenement(@RequestBody Evenements e) {
       // Evenements evenement = evenementsService.addEvenement(e);
     //   return evenement;
   // }
    @PostMapping(value = "/add-evenement",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Evenements> addEvenement(
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFin,
            @RequestParam("lieu") String lieu,
            @RequestParam("categorie") String categorie,
            @RequestParam("nbMaxParticipants") Integer nbMaxParticipants,
            @RequestParam("statut") StatutEvenement statut
    ) {
        try {
            String imagePath = null;
            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadDir = "uploads/";
                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());
                // ✅ On garde un chemin relatif utilisable par Angular
                imagePath = uploadDir + fileName;
            }

            Evenements evenement = new Evenements();
            evenement.setTitre(titre);
            evenement.setDescription(description);
            evenement.setDateDebut(dateDebut);
            evenement.setDateFin(dateFin);
            evenement.setLieu(lieu);
            evenement.setCategorie(categorie);
            evenement.setNbMaxParticipants(nbMaxParticipants);
            evenement.setStatut(statut);
            evenement.setImage(imagePath);



            Evenements saved = evenementsService.addEvenement(evenement);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping(value = "/modify-evenement", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Evenements> updateEvenement(
            @RequestParam("id") Long id,
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("dateDebut") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateDebut,
            @RequestParam("dateFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateFin,
            @RequestParam("lieu") String lieu,
            @RequestParam("categorie") String categorie,
            @RequestParam("nbMaxParticipants") Integer nbMaxParticipants,
            @RequestParam(value = "image", required = false) MultipartFile imageFile
    ) {
        try {
            Evenements evenement = evenementsService.retrieveEvenement(id);
            if (evenement == null) {
                return ResponseEntity.notFound().build();
            }

            evenement.setTitre(titre);
            evenement.setDescription(description);
            evenement.setDateDebut(dateDebut);
            evenement.setDateFin(dateFin);
            evenement.setLieu(lieu);
            evenement.setCategorie(categorie);
            evenement.setNbMaxParticipants(nbMaxParticipants);

            if (imageFile != null && !imageFile.isEmpty()) {
                String uploadDir = "uploads/";
                String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();
                Path filePath = Paths.get(uploadDir + fileName);
                Files.createDirectories(filePath.getParent());
                Files.write(filePath, imageFile.getBytes());

                // mettre à jour le chemin dans l'entité
                evenement.setImage(uploadDir + fileName);
            }

            Evenements updated = evenementsService.modifyEvenement(evenement);
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    // http://localhost:8089/backend/evenements/remove-evenement/{evenement-id}
    @DeleteMapping("/remove-evenement/{evenement-id}")
    public void removeEvenement(@PathVariable("evenement-id") Long evenementId) {
        evenementsService.removeEvenement(evenementId);
    }

    // http://localhost:8089/backend/evenements/modify-evenement
   // @PutMapping("/modify-evenement")
   // public Evenements modifyEvenement(@RequestBody Evenements e) {
    //    Evenements evenement = evenementsService.modifyEvenement(e);
     //   return evenement;
  //  }
    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            // Définir l'emplacement de sauvegarde local
            String uploadDir = "uploads/";
            String fileName = imageFile.getOriginalFilename();

            // Créer le répertoire si nécessaire
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Enregistrer le fichier
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, imageFile.getBytes());

            // Retourner le chemin relatif pour la base de données
            return ResponseEntity.ok(filePath.toString());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'upload");
        }
    }

}
