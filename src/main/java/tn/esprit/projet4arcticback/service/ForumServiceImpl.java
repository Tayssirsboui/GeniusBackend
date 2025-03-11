package tn.esprit.projet4arcticback.service;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Forum;
import tn.esprit.projet4arcticback.entity.Forum;
import tn.esprit.projet4arcticback.repository.ForumRepository;
import tn.esprit.projet4arcticback.repository.ForumRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ForumServiceImpl implements IForumService {
    @Autowired
    ForumRepository forumRepository;
    public List<Forum> retrieveAllForums() {
        return forumRepository.findAll();
    }
    public Forum retrieveForum(Long fId) {
        return forumRepository.findById(fId).get();
    }
    public Forum addForum(Forum f) {
        return forumRepository.save(f);
    }
    public void removeForum(Long fId) {
        forumRepository.deleteById(fId);
    }
    public Forum modifyForum(Forum forum) {
        return forumRepository.save(forum);
    }
}

