package tn.esprit.tprevision.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tprevision.Entities.Projet;

@Repository
public interface ProjetRepo extends JpaRepository<Projet,Long> {
}
