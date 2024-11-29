package tn.esprit.tprevision.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tprevision.Entities.Projet;
import tn.esprit.tprevision.Repositories.ProjetRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    private ProjetRepo projetRepo;

    // Get all Projets
    public List<Projet> getAllProjets() {
        return projetRepo.findAll();
    }

    // Get a Projet by ID
    public Optional<Projet> getProjetById(Integer id) {
        return projetRepo.findById(id);
    }

    // Create or Update a Projet
    public Projet saveOrUpdateProjet(Projet projet) {
        return projetRepo.save(projet);
    }

    // Delete a Projet by ID
    public void deleteProjet(Integer id) {
        projetRepo.deleteById(id);
    }
}
