package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Question;

import java.util.List;

public interface IQuestionService {
    public List<Question> retrieveAllQuestions();
    public Question retrieveQuestion(Long idQuestion);
    public Question addQuestion(Question question);
    public void removeQuestion(Long idQuestion);
    public Question modifyQuestion(Question q);
}
