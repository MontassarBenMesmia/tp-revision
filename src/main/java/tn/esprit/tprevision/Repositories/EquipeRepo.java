package tn.esprit.tprevision.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tprevision.Entities.Equipe;

@Repository
public interface EquipeRepo extends JpaRepository <Equipe,Long> {
}
