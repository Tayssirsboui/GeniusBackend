package tn.esprit.projet4arcticback.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identifiant du stage

    private String type; // Type du stage (ex. PFE, pré-embauche)
    private String domaine; // Domaine du stage (ex. Informatique, Marketing, etc.)
    private LocalDate dateDebut; // Date de début du stage
    private LocalDate dateFin; // Date de fin du stage
    private String entreprise; // Nom de l'entreprise qui propose le stage
    private boolean payant; // Si le stage est payant ou non

    // Constructeur sans argument
    public Stage() {}

    // Constructeur avec tous les attributs (facultatif mais utile)
    public Stage(String type, String domaine, LocalDate dateDebut, LocalDate dateFin, String entreprise, boolean payant) {
        this.type = type;
        this.domaine = domaine;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.entreprise = entreprise;
        this.payant = payant;
    }

    // Getter et Setter pour chaque attribut

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public boolean isPayant() {
        return payant;
    }

    public void setPayant(boolean payant) {
        this.payant = payant;
    }

    // ToString, HashCode, Equals si nécessaire
    @Override
    public String toString() {
        return "Stage{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", domaine='" + domaine + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", entreprise='" + entreprise + '\'' +
                ", payant=" + payant +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return payant == stage.payant &&
                id.equals(stage.id) &&
                type.equals(stage.type) &&
                domaine.equals(stage.domaine) &&
                dateDebut.equals(stage.dateDebut) &&
                dateFin.equals(stage.dateFin) &&
                entreprise.equals(stage.entreprise);
    }


}