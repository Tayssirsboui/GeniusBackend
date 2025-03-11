package tn.esprit.projet4arcticback.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Question;
import tn.esprit.projet4arcticback.repository.QuestionRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    QuestionRepository questionRepository;
    public List<Question> retrieveAllQuestions() {
        return questionRepository.findAll();
    }
    public Question retrieveQuestion(Long idQuestion) {
        return questionRepository.findById(idQuestion).orElse(null);
    }
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
    public void removeQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }
    public Question modifyQuestion(Question question) {
        return questionRepository.save(question);
    }
}

