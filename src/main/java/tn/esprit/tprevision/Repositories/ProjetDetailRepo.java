package tn.esprit.tprevision.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tprevision.Entities.Equipe;
import tn.esprit.tprevision.Entities.ProjetDetail;

@Repository
public interface ProjetDetailRepo extends JpaRepository<ProjetDetail,Long> {
}
