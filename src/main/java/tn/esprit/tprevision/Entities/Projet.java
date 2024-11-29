package tn.esprit.tprevision.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="projets")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sujet;

    @ManyToMany(mappedBy = "projets")
    private List<Equipe> Equipes;

    @OneToOne(mappedBy = "projet")
    private ProjetDetail projetDetail;
}
