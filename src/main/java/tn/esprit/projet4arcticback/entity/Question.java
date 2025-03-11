package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idQuestion;
    private String object;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String createdBy;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="question")
    private Set<Reponse> reponses;

}
