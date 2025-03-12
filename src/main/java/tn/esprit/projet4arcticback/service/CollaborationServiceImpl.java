package tn.esprit.projet4arcticback.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.entity.Collaboration;
import tn.esprit.projet4arcticback.repository.CollaborationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CollaborationServiceImpl implements ICollaborationService {
    @Autowired
    private  CollaborationRepository collaborationRepository;

    public List<Collaboration> retrieveAllCollaborations() {
        return collaborationRepository.findAll();
    }

    public Collaboration retrieveCollaboration(Long collaborationId) {
        return collaborationRepository.findById(collaborationId).orElse(null);
    }

    public Collaboration addCollaboration(Collaboration c) {
        return collaborationRepository.save(c);
    }

    public void removeCollaboration(Long collaborationId) {
        collaborationRepository.deleteById(collaborationId);
    }

    public Collaboration modifyCollaboration(Collaboration collaboration) {
        return collaborationRepository.save(collaboration);
    }
}
