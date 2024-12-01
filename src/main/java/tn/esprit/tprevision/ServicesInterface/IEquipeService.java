package tn.esprit.tprevision.ServicesInterface;

import tn.esprit.tprevision.Entities.Equipe;

import java.util.List;
import java.util.Optional;

public interface IEquipeService {

    // Get all Equipes
    List<Equipe> getAllEquipes();

    // Create an Equipe
    Equipe createEquipe(Equipe equipe);

    // Delete an Equipe by ID
    void deleteEquipe(Long id);
}
