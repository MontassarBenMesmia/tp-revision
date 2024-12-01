package tn.esprit.tprevision.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tprevision.Entities.Equipe;
import tn.esprit.tprevision.Services.EquipeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    // Get all Equipes
    @GetMapping
    public List<Equipe> getAllEquipes() {
        return equipeService.getAllEquipes();
    }

    // Get a specific Equipe by ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeService.getEquipeById(id);
        return equipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new Equipe
    @PostMapping
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        Equipe savedEquipe = equipeService.createEquipe(equipe); // Use createEquipe instead of saveOrUpdateEquipe
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEquipe);
    }

    // Update an existing Equipe
    @PutMapping("/{id}")
    public ResponseEntity<Equipe> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        Optional<Equipe> existingEquipe = equipeService.getEquipeById(id);
        if (existingEquipe.isPresent()) {
            equipe.setId(id); // Ensure the ID is set for update
            Equipe updatedEquipe = equipeService.createEquipe(equipe); // You can use createEquipe for update as well
            return ResponseEntity.ok(updatedEquipe);
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if the equipe doesn't exist
        }
    }

    // Delete an Equipe by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipe(@PathVariable Long id) {
        Optional<Equipe> equipe = equipeService.getEquipeById(id);
        if (equipe.isPresent()) {
            equipeService.deleteEquipe(id);
            return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if the equipe doesn't exist
        }
    }
}