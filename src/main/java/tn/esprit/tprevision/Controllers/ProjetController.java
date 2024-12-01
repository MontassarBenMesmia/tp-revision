package tn.esprit.tprevision.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tprevision.Entities.Projet;
import tn.esprit.tprevision.Services.ProjetService;
import tn.esprit.tprevision.ServicesInterface.IProjetService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projets")
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    // Get all Projets
    @GetMapping
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    // Get a Projet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Optional<Projet> projet = projetService.getProjetById(id);
        return projet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Projet
    @PostMapping
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        Projet savedProjet = projetService.saveOrUpdateProjet(projet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjet);
    }

    // Update an existing Projet
    @PutMapping("/{id}")
    public ResponseEntity<Projet> updateProjet(@PathVariable Long id, @RequestBody Projet projet) {
        projet.setId(id); // Ensure the ID is set for update
        Projet updatedProjet = projetService.saveOrUpdateProjet(projet);
        return ResponseEntity.ok(updatedProjet);
    }

    // Delete a Projet by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Long id) {
        projetService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjetAndProjetDetail(@RequestBody Projet projet) {
        return projetService.addProjetAndProjetDetailAndAssign(projet);
    }

    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                            @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }

    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void affecterProjetAEquipe(@PathVariable("projet-id") Long projetId,
                                      @PathVariable("equipe-id") Long equipeId) {
        projetService.assignProjetToEquipe(projetId, equipeId);
    }


    @PostMapping("/ajouterProjetEtAffecterProjetDetail/{projetDetailId}")
    public Projet ajouterProjetEtAffecterProjetDetail(@RequestBody Projet projet,@PathVariable Long projetDetailId) {
        return projetService.ajouterProjetEtAffecterProjetDetail(projet,projetDetailId);
    }
    @PutMapping("/DesaffecterProjetDetailDeProjet/{projetId}")
    public Projet DesaffecterProjetDetailDeProjet(@PathVariable Long projetId) {
        return   projetService.DesaffecterProjetDetailDeProjet(projetId);
    }
    @PutMapping("/desaffecterProjetDeEquipe/{projetId}/{equipeId}")
    public void desaffecterProjetDeEquipe(@PathVariable Long projetId, @PathVariable Long equipeId) {
        projetService.desaffecterProjetDeEquipe(projetId, equipeId);
    }


}