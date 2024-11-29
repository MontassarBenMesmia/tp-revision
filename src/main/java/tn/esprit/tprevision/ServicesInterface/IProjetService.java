package tn.esprit.tprevision.ServicesInterface;

import tn.esprit.tprevision.Entities.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjetService {

    // Get all Projets
    List<Projet> getAllProjets();

    // Get a Projet by ID
    Optional<Projet> getProjetById(Integer id);

    // Create or Update a Projet
    Projet saveOrUpdateProjet(Projet projet);

    // Delete a Projet by ID
    void deleteProjet(Integer id);
}

