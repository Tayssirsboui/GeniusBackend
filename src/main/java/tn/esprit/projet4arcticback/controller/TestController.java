package tn.esprit.projet4arcticback.controller;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import tn.esprit.projet4arcticback.dto.QuestionDTO;
import tn.esprit.projet4arcticback.dto.SubmitTestDTO;
import tn.esprit.projet4arcticback.dto.testDTO;
import tn.esprit.projet4arcticback.entity.Question;
import tn.esprit.projet4arcticback.entity.Test;
import tn.esprit.projet4arcticback.service.TestService;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.repository.TestRepository;
import tn.esprit.projet4arcticback.repository.QuestionRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/test")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping()
    public ResponseEntity<?> createTest(@RequestBody testDTO dto) {
        try {
            return new ResponseEntity<>(testService.createTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/question")
    public ResponseEntity<?> addQuestionInTest(@RequestBody QuestionDTO dto) {
        try {
            // Call the service method to add the question and return a successful response
            return new ResponseEntity<>(testService.addQuestionInTest(dto), HttpStatus.CREATED);
        } catch (Exception e) {
            // Catch any exception and return a bad request with the error message
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping()
    public ResponseEntity<?> getAllTests() {
        try {
            return new ResponseEntity<>(testService.getAllTests(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllQuestions(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(testService.getAllQuestionsByTest(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/submit-test")
    public ResponseEntity<?> submitTest(@RequestBody SubmitTestDTO dto) {
        try {
            return new ResponseEntity<>(testService.submitTest(dto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/test-result")
    public ResponseEntity<?> getAllTestResults() {
        try {
            return new ResponseEntity<>(testService.getAllTestResults(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }
        @DeleteMapping("/test/{id}")
        public ResponseEntity<?> deleteTest(@PathVariable Long id) {
            try {
                // Call the service method to delete the test and return a successful response
                testService.deleteTest(id);
                return new ResponseEntity<>("Test deleted successfully", HttpStatus.OK);
            } catch (EntityNotFoundException e) {
                // Handle case where the test is not found
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }









}

