package tn.esprit.projet4arcticback.dto;
import lombok.Data;



@Data
public class TestResultDTO {

    private Long id;
    private int totalQuestions;
    private int correctAnswers;
    private double percentage;
    private String testName;
}
