package tn.esprit.projet4arcticback.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.projet4arcticback.entity.User;
import tn.esprit.projet4arcticback.service.UserService;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")

@RequestMapping("/api/users")
public class UserController {

    private UserService userservice;

    // Endpoint to get all users
    @GetMapping
    public List<User> getUsers() {
        return userservice.getAllUsers();
    }
}