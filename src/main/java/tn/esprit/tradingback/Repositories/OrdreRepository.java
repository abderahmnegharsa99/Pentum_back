package tn.esprit.tradingback.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tradingback.Entities.Marche;
import tn.esprit.tradingback.Entities.Ordre;

import java.util.List;

@Repository

public interface OrdreRepository extends JpaRepository<Ordre, Long> {
    List<Ordre> findByEtat(String etat);


    List<Ordre> findByPortfeuille_UserIdU(Long userId);

}
