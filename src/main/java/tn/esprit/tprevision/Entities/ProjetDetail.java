package tn.esprit.tprevision.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Entity
@Getter
@Setter
public class ProjetDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String technologie;
    private Long cout;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @OneToOne(mappedBy = "projetDetail")
    @ToString.Exclude
    @JsonIgnore
    private Projet projet;

}