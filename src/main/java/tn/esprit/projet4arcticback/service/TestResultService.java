package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.TestResult;
import java.util.List;

public interface TestResultService {
    List<TestResult> getAllTestResults();
    TestResult getTestResultById(Long id);
    TestResult createTestResult(TestResult testResult);
    TestResult updateTestResult(Long id, TestResult testResult);
    void deleteTestResult(Long id);
}
