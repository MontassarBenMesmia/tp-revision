package tn.esprit.tprevision.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tprevision.Entities.Equipe;
import tn.esprit.tprevision.Repositories.EquipeRepo;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepo equipeRepo;

    // Get all Equipes
    public List<Equipe> getAllEquipes() {
        return equipeRepo.findAll();
    }

    // Get a specific Equipe by ID
    public Optional<Equipe> getEquipeById(Integer id) {
        return equipeRepo.findById(id);
    }

    // Create or Update an Equipe
    public Equipe createEquipe(Equipe equipe) {
        return equipeRepo.save(equipe);
    }

    // Delete an Equipe by ID
    public void deleteEquipe(Integer id) {
        equipeRepo.deleteById(id);
    }
}