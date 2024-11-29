package tn.esprit.tprevision.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tprevision.Entities.ProjetDetail;
import tn.esprit.tprevision.Repositories.ProjetDetailRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetDetailService {

    @Autowired
    private ProjetDetailRepo projetDetailRepo;

    // Get all ProjetDetails
    public List<ProjetDetail> getAllProjetDetails() {
        return projetDetailRepo.findAll();
    }

    // Get a ProjetDetail by ID
    public Optional<ProjetDetail> getProjetDetailById(Long id) {
        return projetDetailRepo.findById(id);
    }

    // Create or Update a ProjetDetail
    public ProjetDetail saveOrUpdateProjetDetail(ProjetDetail projetDetail) {
        return projetDetailRepo.save(projetDetail);
    }

    // Delete a ProjetDetail by ID
    public void deleteProjetDetail(Long id) {
        projetDetailRepo.deleteById(id);
    }
}
