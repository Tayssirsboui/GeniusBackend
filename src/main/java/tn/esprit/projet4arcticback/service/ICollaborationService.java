package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Collaboration;

import java.util.List;

public interface ICollaborationService {
    List<Collaboration> retrieveAllCollaborations();
    Collaboration retrieveCollaboration(Long collaborationId);
    Collaboration addCollaboration(Collaboration c);
    void removeCollaboration(Long collaborationId);
    Collaboration modifyCollaboration(Collaboration collaboration);
}
