package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.dto.*;
import tn.esprit.projet4arcticback.entity.Test;
import java.util.List;

public interface TestService {
    public testDTO createTest(testDTO dto);
    public QuestionDTO addQuestionInTest(QuestionDTO dto);

    public List<testDTO> getAllTests();

    public TestDetailsDTO getAllQuestionsByTest(Long id);

    public TestResultDTO submitTest(SubmitTestDTO request);

    public List<TestResultDTO> getAllTestResults();
    public void deleteTest(Long id);
}
