package tn.esprit.projet4arcticback.service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Discussion;
import tn.esprit.projet4arcticback.entity.Discussion;
import tn.esprit.projet4arcticback.repository.DiscussionRepository;
import tn.esprit.projet4arcticback.repository.DiscussionRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DiscussionServiceImpl implements IDiscussionService {
    @Autowired
    DiscussionRepository discussionRepository;
    public List<Discussion> retrieveAllDiscussions() {
        return discussionRepository.findAll();
    }
    public Discussion retrieveDiscussion(Long dId) {
        return discussionRepository.findById(dId).get();
    }
    public Discussion addDiscussion(Discussion d) {
        return discussionRepository.save(d);
    }
    public void removeDiscussion(Long dId) {
        discussionRepository.deleteById(dId);
    }
    public Discussion modifyDiscussion(Discussion discussion) {
        return discussionRepository.save(discussion);
    }
}

