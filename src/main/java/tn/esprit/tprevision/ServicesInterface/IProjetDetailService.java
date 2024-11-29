package tn.esprit.tprevision.ServicesInterface;

import tn.esprit.tprevision.Entities.ProjetDetail;

import java.util.List;
import java.util.Optional;

public interface IProjetDetailService {

    // Get all ProjetDetails
    List<ProjetDetail> getAllProjetDetails();

    // Get a ProjetDetail by ID
    Optional<ProjetDetail> getProjetDetailById(Long id);

    // Create or Update a ProjetDetail
    ProjetDetail saveOrUpdateProjetDetail(ProjetDetail projetDetail);

    // Delete a ProjetDetail by ID
    void deleteProjetDetail(Long id);
}

