package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fId;
    private String name;
    private String  description;
    private LocalDateTime createdAt;

    @OneToMany(cascade =CascadeType.ALL,mappedBy = "forum")
    private Set<Discussion> discussion;
}
