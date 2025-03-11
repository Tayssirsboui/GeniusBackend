package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Question;
import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    Question createQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
}
