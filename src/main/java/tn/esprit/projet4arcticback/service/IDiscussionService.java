package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Discussion;

import java.util.List;

public interface IDiscussionService {
    public List<Discussion> retrieveAllDiscussions();

    public Discussion retrieveDiscussion(Long dId);

    public Discussion addDiscussion(Discussion d);

    public void removeDiscussion(Long dId);

    public Discussion modifyDiscussion(Discussion discussion);
}