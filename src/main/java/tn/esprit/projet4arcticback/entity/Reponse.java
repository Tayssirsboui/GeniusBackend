package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.projet4arcticback.service.QuestionServiceImpl;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idReponse;
    private String object;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedAt;
    private String CreatedBy;
    @ManyToOne
    Question question;

}
