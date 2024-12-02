package tn.esprit.tprevision.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tprevision.Entities.Projet;

import java.util.List;

@Service
public class ProjetSchedulerService {

    private static final Logger logger = LoggerFactory.getLogger(ProjetSchedulerService.class);

    private final ProjetService projetService;

    public ProjetSchedulerService(ProjetService projetService) {
        this.projetService = projetService;
    }

    @Scheduled(cron = "0 * * * * ?")
    public void afficherTousLesProjets() {
        List<Projet> projets = projetService.getAllProjets();
        logger.info("Liste des projets: ");
        projets.forEach(projet -> logger.info("Projet ID: {}, Sujet: {}", projet.getId(), projet.getSujet()));
    }


    @Scheduled(cron = "*/50 * * * * ?")
    public void mettreAJourEtAfficherProjets() {
        List<Projet> projets = projetService.getAllProjets();
        projets.forEach(projet -> {
            if (projet.getSujet().startsWith("test")) {
                projet.setSujet("-");
                projetService.saveOrUpdateProjet(projet);
                logger.info("Sujet mis à jour pour le projet ID: {}", projet.getId());
            }
        });
        afficherTousLesProjets();
    }
}
