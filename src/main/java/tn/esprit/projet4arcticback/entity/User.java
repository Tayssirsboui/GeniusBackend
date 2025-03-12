package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "nom", length = 225, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 225, nullable = false)
    private String prenom;

    @Column(name = "numero")
    private Long numero; // `long` remplacé par `Long` pour éviter les valeurs nulles

    @Column(name = "status", length = 225)
    private String status;

    @Column(name = "competence", length = 225)
    private String competence;

    @ManyToOne
    @JoinColumn(name = "roleId", nullable = false) // Correspond à l'attribut `roleId` de `Role`
    private Role role;
}
