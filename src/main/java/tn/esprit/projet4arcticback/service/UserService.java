package tn.esprit.projet4arcticback.service;
import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.projet4arcticback.repository.UserRepository;
import tn.esprit.projet4arcticback.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.security.Principal;
import tn.esprit.projet4arcticback.RestController.ChangePasswordRequest;
import  tn.esprit.projet4arcticback.exception.ResourceNotFoundException;
@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is correct
        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        // check if the two new passwords are the same
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        // update the password
        user.setMotDePasse(passwordEncoder.encode(request.getNewPassword()));

        // save the new password
        userRepository.save(user);
    }


    @Transactional
    public User modifyUser(User user) {
        // 1. Vérifier que l'utilisateur existe
        User existing = userRepository.findById(user.getIdUser())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "id", user.getIdUser()));

        boolean updated = false;

        // 2. Mettre à jour les champs non nuls
        if (user.getNom() != null && !user.getNom().isBlank()) {
            existing.setNom(user.getNom());
            updated = true;
        }
        if (user.getEmail() != null && !user.getEmail().isBlank()) {
            existing.setEmail(user.getEmail());
            updated = true;
        }
        if (user.getImage() != null && !user.getImage().isBlank()) {
            existing.setImage(user.getImage());
            updated = true;
        }
        // … répète pour chaque champ modifiable

        // 3. Si rien n’a changé, on ne fait pas de save inutile
        if (!updated) {
            throw new IllegalStateException("Aucun champ valide fourni pour la mise à jour.");
        }

        // 4. Sauvegarder et retourner
        return userRepository.save(existing);
    }
    @Transactional(Transactional.TxType.SUPPORTS)
    public User getUserById(Long idUser) {
        return userRepository.findById(idUser)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User", "idUser", idUser));
    }
}
