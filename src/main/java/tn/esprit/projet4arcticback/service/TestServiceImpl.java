package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Test;
import tn.esprit.projet4arcticback.repository.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public Test getTestById(Long id) {
        return testRepository.findById(id).orElse(null);
    }

    @Override
    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Test updateTest(Long id, Test test) {
        if (testRepository.existsById(id)) {
            test.setId(id);
            return testRepository.save(test);
        }
        return null;
    }

    @Override
    public void deleteTest(Long id) {
        testRepository.deleteById(id);
    }
}
