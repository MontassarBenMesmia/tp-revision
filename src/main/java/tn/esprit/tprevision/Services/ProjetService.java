package tn.esprit.tprevision.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tprevision.Entities.Equipe;
import tn.esprit.tprevision.Entities.Projet;
import tn.esprit.tprevision.Entities.ProjetDetail;
import tn.esprit.tprevision.Repositories.EquipeRepo;
import tn.esprit.tprevision.Repositories.ProjetDetailRepo;
import tn.esprit.tprevision.Repositories.ProjetRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepo projetRepo;
    @Autowired
    private EquipeRepo equipeRepo;
    @Autowired
    private ProjetDetailRepo projetDetailRepo;

    // Get all Projets
    public List<Projet> getAllProjets() {
        return projetRepo.findAll();
    }

    // Get a Projet by ID
    public Optional<Projet> getProjetById(Long id) {
        return projetRepo.findById(id);
    }

    // Create or Update a Projet
    public Projet saveOrUpdateProjet(Projet projet) {
        return projetRepo.save(projet);
    }

    // Delete a Projet by ID
    public void deleteProjet(Long id) {
        projetRepo.deleteById(id);
    }

    // Ajouter un projet avec son ProjetDetail
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
        // Enregistrement du projet et de son détail grâce au cascade
        return projetRepo.save(projet);
    }
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepo.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepo.findById(projetDetailId).get();
        // on set le fils dans le parent :
        projet.setProjetDetail(projetDetail);
        projetRepo.save(projet);
    }

    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepo.findById(projetId).get();
        Equipe equipe = equipeRepo.findById(equipeId).get();
        // on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepo.save(equipe);
    }

    public Projet ajouterProjetEtAffecterProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepo.findById(projetDetailId).orElse(null);
        projet.setProjetDetail(projetDetail);
        return projetRepo.save(projet);
    }

    public Projet DesaffecterProjetDetailDeProjet(Long projetId) {
        Projet projet = projetRepo.findById(projetId).orElse(null);
        projet.setProjetDetail(null);
        return projetRepo.save(projet);
    }

    public void desaffecterProjetDeEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepo.findById(projetId).orElse(null);
        Equipe equipe = equipeRepo.findById(equipeId).orElse(null);
        equipe.getProjets().remove(projet);
        equipeRepo.save(equipe);

    }
}
