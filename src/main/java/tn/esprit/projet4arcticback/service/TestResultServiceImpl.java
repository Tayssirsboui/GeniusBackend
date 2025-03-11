package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.TestResult;
import tn.esprit.projet4arcticback.repository.TestResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestResultServiceImpl implements TestResultService {
    private final TestResultRepository testResultRepository;

    public TestResultServiceImpl(TestResultRepository testResultRepository) {
        this.testResultRepository = testResultRepository;
    }

    @Override
    public List<TestResult> getAllTestResults() {
        return testResultRepository.findAll();
    }

    @Override
    public TestResult getTestResultById(Long id) {
        return testResultRepository.findById(id).orElse(null);
    }

    @Override
    public TestResult createTestResult(TestResult testResult) {
        return testResultRepository.save(testResult);
    }

    @Override
    public TestResult updateTestResult(Long id, TestResult testResult) {
        if (testResultRepository.existsById(id)) {
            testResult.setId(id);
            return testResultRepository.save(testResult);
        }
        return null;
    }

    @Override
    public void deleteTestResult(Long id) {
        testResultRepository.deleteById(id);
    }
}
