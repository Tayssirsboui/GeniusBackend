package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    public void setId(Long id) {
        this.id = id;
    }
}
