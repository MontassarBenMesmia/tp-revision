package tn.esprit.tprevision.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tprevision.Entities.Projet;
import tn.esprit.tprevision.Services.ProjetService;

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
    public ResponseEntity<Projet> getProjetById(@PathVariable Integer id) {
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
    public ResponseEntity<Projet> updateProjet(@PathVariable Integer id, @RequestBody Projet projet) {
        projet.setId(id); // Ensure the ID is set for update
        Projet updatedProjet = projetService.saveOrUpdateProjet(projet);
        return ResponseEntity.ok(updatedProjet);
    }

    // Delete a Projet by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjet(@PathVariable Integer id) {
        projetService.deleteProjet(id);
        return ResponseEntity.noContent().build();
    }
}