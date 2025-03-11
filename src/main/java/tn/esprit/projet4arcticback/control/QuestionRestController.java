package tn.esprit.projet4arcticback.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Question;
import tn.esprit.projet4arcticback.service.QuestionServiceImpl;

import java.util.List;

@Tag(name = "Gestion des Questions")
@RestController
@AllArgsConstructor
@RequestMapping("/question")
public class QuestionRestController {
    @Autowired

    QuestionServiceImpl questionService;

    // Récupérer toutes les questions
    @Operation(description = "Récupérer la liste de toutes les questions enregistrées")
    @GetMapping("/retrieve-all-questions")
    public List<Question> getQuestions() {
        return questionService.retrieveAllQuestions();
    }

    // Récupérer une question par ID
    @Operation(description = "Récupérer une question spécifique en fournissant son ID")
    @GetMapping("/retrieve-question/{question-id}")
    public Question retrieveQuestion(@PathVariable("question-id") Long questionId) {
        return questionService.retrieveQuestion(questionId);
    }

    // Ajouter une question
    @Operation(description = "Ajouter une nouvelle question")
    @PostMapping("/add-question")
    public Question addQuestion(@RequestBody Question q) {
        return questionService.addQuestion(q);
    }

    // Supprimer une question par ID
    @Operation(description = "Supprimer une question en fournissant son ID")
    @DeleteMapping("/remove-question/{question-id}")
    public void removeQuestion(@PathVariable("question-id") Long questionId) {
        questionService.removeQuestion(questionId);
    }

    // Modifier une question existante
    @Operation(description = "Mettre à jour les informations d'une question existante")
    @PutMapping("/modify-question")
    public Question modifyQuestion(@RequestBody Question q) {
        return questionService.modifyQuestion(q);
    }
}


