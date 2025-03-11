package tn.esprit.projet4arcticback.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.projet4arcticback.entity.Discussion;
import tn.esprit.projet4arcticback.service.IDiscussionService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/discussion")

public class DiscussionRestControl {
    @Autowired
    IDiscussionService discussionService;
    // http://localhost:8089/projet4arcticback/discussion/retrieve-all-discussions
    @GetMapping("/retrieve-all-discussions")
    public List<Discussion> getDiscussions() {
        List<Discussion> listDiscussions = discussionService.retrieveAllDiscussions();
        return listDiscussions;
    }
    // http://localhost:8089/projet4arcticback/discussion/retrieve-all-discussions
    @GetMapping("/retrieve-discussion/{discussion-id}")
    public Discussion retrieveDiscussion(@PathVariable("discussion-id") Long dId) {
        Discussion discussion = discussionService.retrieveDiscussion(dId);
        return discussion;
    }
    // http://localhost:8089/projet4arcticback/discussion/retrieve-all-discussions
    @PostMapping("/add-discussion")
    public Discussion addDiscussion(@RequestBody Discussion d) {
        Discussion discussion = discussionService.addDiscussion(d);
        return discussion;
    }
    // http://localhost:8089/projet4arcticback/discussion/retrieve-all-discussions
    @DeleteMapping("/remove-discussion/{discussion-id}")
    public void removeDiscussion(@PathVariable("discussion-id") Long dId) {
        discussionService.removeDiscussion(dId);
    }
    // http://localhost:8089/projet4arcticback/discussion/retrieve-all-discussions
    @PutMapping("/modify-discussion")
    public Discussion modifyDiscussion(@RequestBody Discussion d) {
        Discussion discussion = discussionService.modifyDiscussion(d);
        return discussion;
    }
}
