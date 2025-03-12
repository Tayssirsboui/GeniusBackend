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
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mieux adapté aux bases qui auto-incrémentent
    private int roleId;

    @Column(name = "role_name", length = 225, unique = true, nullable = false)
    private String roleName;
}