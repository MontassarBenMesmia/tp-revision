package tn.esprit.tprevision.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="projets")
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sujet;

    @ManyToMany(mappedBy = "projets")
    @ToString.Exclude
    @JsonIgnore
    private List<Equipe> Equipes;

    @OneToOne(cascade = CascadeType.ALL)
    private ProjetDetail projetDetail;
}
