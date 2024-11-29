package tn.esprit.tprevision.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tprevision.Entities.ProjetDetail;
import tn.esprit.tprevision.Services.ProjetDetailService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projet-details")
public class ProjetDetailController {

    @Autowired
    private ProjetDetailService projetDetailService;

    // Get all ProjetDetails
    @GetMapping
    public List<ProjetDetail> getAllProjetDetails() {
        return projetDetailService.getAllProjetDetails();
    }

    // Get a ProjetDetail by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjetDetail> getProjetDetailById(@PathVariable Long id) {
        Optional<ProjetDetail> projetDetail = projetDetailService.getProjetDetailById(id);
        return projetDetail.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new ProjetDetail
    @PostMapping
    public ResponseEntity<ProjetDetail> createProjetDetail(@RequestBody ProjetDetail projetDetail) {
        ProjetDetail savedProjetDetail = projetDetailService.saveOrUpdateProjetDetail(projetDetail);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProjetDetail);
    }

    // Update an existing ProjetDetail
    @PutMapping("/{id}")
    public ResponseEntity<ProjetDetail> updateProjetDetail(@PathVariable Long id, @RequestBody ProjetDetail projetDetail) {
        projetDetail.setId(id); // Ensure the ID is set for update
        ProjetDetail updatedProjetDetail = projetDetailService.saveOrUpdateProjetDetail(projetDetail);
        return ResponseEntity.ok(updatedProjetDetail);
    }

    // Delete a ProjetDetail by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjetDetail(@PathVariable Long id) {
        projetDetailService.deleteProjetDetail(id);
        return ResponseEntity.noContent().build();
    }
}
