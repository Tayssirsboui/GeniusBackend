package tn.esprit.projet4arcticback.controller;

import tn.esprit.projet4arcticback.entity.TestResult;
import tn.esprit.projet4arcticback.service.TestResultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test-results")
public class TestResultController {
    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping
    public List<TestResult> getAllTestResults() {
        return testResultService.getAllTestResults();
    }

    @GetMapping("/{id}")
    public TestResult getTestResultById(@PathVariable Long id) {
        return testResultService.getTestResultById(id);
    }

    @PostMapping
    public TestResult createTestResult(@RequestBody TestResult testResult) {
        return testResultService.createTestResult(testResult);
    }

    @PutMapping("/{id}")
    public TestResult updateTestResult(@PathVariable Long id, @RequestBody TestResult testResult) {
        return testResultService.updateTestResult(id, testResult);
    }

    @DeleteMapping("/{id}")
    public void deleteTestResult(@PathVariable Long id) {
        testResultService.deleteTestResult(id);
    }
}
