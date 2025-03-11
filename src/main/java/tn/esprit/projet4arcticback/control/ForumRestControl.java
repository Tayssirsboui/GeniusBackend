package tn.esprit.projet4arcticback.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Forum;
import tn.esprit.projet4arcticback.service.IForumService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/forum")

public class ForumRestControl {
    @Autowired
    IForumService forumService;
    // http://localhost:8089/projet4arcticback/forum/retrieve-all-forums
    @GetMapping("/retrieve-all-forums")
    public List<Forum> getForums() {
        List<Forum> listForums = forumService.retrieveAllForums();
        return listForums;
    }
    // http://localhost:8089/projet4arcticback/forum/retrieve-all-forums
    @GetMapping("/retrieve-forum/{forum-id}")
    public Forum retrieveForum(@PathVariable("forum-id") Long fId) {
        Forum forum = forumService.retrieveForum(fId);
        return forum;
    }
    // http://localhost:8089/projet4arcticback/forum/retrieve-all-forums
    @PostMapping("/add-forum")
    public Forum addForum(@RequestBody Forum f) {
        Forum forum = forumService.addForum(f);
        return forum;
    }
    // http://localhost:8089/projet4arcticback/forum/retrieve-all-forums
    @DeleteMapping("/remove-forum/{forum-id}")
    public void removeForum(@PathVariable("forum-id") Long fId) {
        forumService.removeForum(fId);
    }
    // http://localhost:8089/projet4arcticback/forum/retrieve-all-forums
    @PutMapping("/modify-forum")
    public Forum modifyForum(@RequestBody Forum f) {
        Forum forum = forumService.modifyForum(f);
        return forum;
    }
}
