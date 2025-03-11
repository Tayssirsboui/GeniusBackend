package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Test;
import java.util.List;

public interface TestService {
    List<Test> getAllTests();
    Test getTestById(Long id);
    Test createTest(Test test);
    Test updateTest(Long id, Test test);
    void deleteTest(Long id);
}
