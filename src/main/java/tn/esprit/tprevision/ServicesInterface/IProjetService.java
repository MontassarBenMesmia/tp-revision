package tn.esprit.tprevision.ServicesInterface;

import tn.esprit.tprevision.Entities.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjetService {

    // Get all Projets
    public List<Projet> getAllProjets();

    // Get a Projet by ID
    public Optional<Projet> getProjetById(Integer id);

    // Create or Update a Projet
    public Projet saveOrUpdateProjet(Projet projet);

    // Delete a Projet by ID
    public void deleteProjet(Long id);

    public Projet addProjetAndProjetDetailAndAssign(Projet projet);

    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);

    public void assignProjetToEquipe(Long projetId, Long equipeId);

    public Projet ajouterProjetEtAffecterProjetDetail(Projet projet, Long projetDetailId);

    public Projet DesaffecterProjetDetailDeProjet(Long projetId);
    public void desaffecterProjetDeEquipe(Long projetId, Long equipeId);


}

