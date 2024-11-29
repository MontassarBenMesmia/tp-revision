package tn.esprit.tprevision.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;

    @Enumerated(EnumType.STRING)
    private Domaine domaine;

    @ManyToMany
    private List<Projet> projets;
}

