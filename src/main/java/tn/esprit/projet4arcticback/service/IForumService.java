package tn.esprit.projet4arcticback.service;

import tn.esprit.projet4arcticback.entity.Forum;

import java.util.List;

public interface IForumService {
    public List<Forum> retrieveAllForums();
    public Forum retrieveForum(Long fId);
    public Forum addForum(Forum f);
    public void removeForum(Long fId);
    public Forum modifyForum(Forum forum);
}
