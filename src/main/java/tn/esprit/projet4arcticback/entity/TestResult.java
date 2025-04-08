package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.Data;
import tn.esprit.projet4arcticback.dto.TestResultDTO;

@Entity
@Data
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int totalQuestions;
    private int correctAnswers;
    private double percentage;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public TestResultDTO getDto() {
        TestResultDTO dto = new TestResultDTO();

        dto.setId(id);
        dto.setTotalQuestions(totalQuestions);
        dto.setCorrectAnswers(correctAnswers);
        dto.setPercentage(percentage);
        dto.setTestName(test.getTitle());

        return dto;
    }

}
